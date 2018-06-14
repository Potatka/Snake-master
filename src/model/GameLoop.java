package model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

import static javafx.scene.input.KeyCode.*;

public class GameLoop {
    Scene scene;
    int moveDirection;
    int score;
    boolean foodSpawned;
    Stage stage;
    Pane pane;
    Circle foodNode;
    Snake snake;
    int b;
    int a;

    public GameLoop(Scene scene, Stage stage, Pane pane, Circle foodNode, Snake snake) {
        this.scene = scene;
        moveDirection = 1;
        foodSpawned = false;
        this.stage = stage;
        this.pane = pane;
        this.foodNode = foodNode;
        this.snake = snake;
        a = 0;
        b = 1;

    }

    public void startCycle(Snake snake, Food food, Rectangle snakeHead) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        //Rectangle snakeHead = snake.returnNode();
        //snakeHead.relocate(5,200);


        KeyFrame kf = new KeyFrame(Duration.seconds(0.05),
                new EventHandler<ActionEvent>() {


                    public void handle(ActionEvent event) {
                        //  while(!foodSpawned){

                        foodSpawned = true;

                        movingSnake(snakeHead, foodNode, pane, snake);

                    }
                });


        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void moveSnake(Rectangle snakeHead, int direction) {
        switch (direction) {
            case 1:
                snakeHead.setX(snakeHead.getX() + 10);
                break;
            case 2:
                snakeHead.setY(snakeHead.getY() + 10);
                break;
            case 3:
                snakeHead.setX(snakeHead.getX() - 10);
                break;
            case 4:
                snakeHead.setY(snakeHead.getY() - 10);
                break;

        }


    }

    private void moveCircleOnKeyPress(Scene scene, Rectangle snakeHead) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {

                    case UP:
                        moveDirection = 4;
                        break;

                    case RIGHT:
                        moveDirection = 1;
                        break;

                    case DOWN:
                        moveDirection = 2;
                        break;

                    case LEFT:
                        moveDirection = 3;
                        break;

                }

            }

        });


    }

    public void movingSnake(Rectangle snakeHead, Circle foodNode, Pane pane, Snake snake) {
        snake.writeCurrentPosition(snakeHead);
        moveSnake(snakeHead, moveDirection);
        checkColission(snakeHead, foodNode, pane);
        moveCircleOnKeyPress(scene, snakeHead);
        if (snake.rectangleList.size() >= 2 && snake.rectangleList.size() <= 3) {
            for (Node node : snake.nodeList) {

                snake.followSnakeHead(a, b - 1);
                if (a >= 1 && b <= snake.rectangleList.size() - 1) b++;
                a++;
            }
        }


        System.out.println(snake.rectangleList.toString());
        System.out.println(snake.count);
        checkBoundsOut(snakeHead);

        //   System.out.println(snakeHead.getY());


    }

    public void checkColission(Rectangle snakeHead, Circle foodNode, Pane pane) {
        if (snakeHead.getBoundsInParent().intersects(foodNode.getBoundsInParent())) {
            foodNode.relocate(Math.random() * 480, Math.random() * 320);
            Node node = snake.spawnNewNode();
            Rectangle rectangle = node.spawnRectangle();
            snake.rectangleList.add(rectangle);

            Node nod = snake.spawnNewNode();
            Rectangle rec = nod.spawnRectangle();
            snake.rectangleList.add(rec);

            // snake.writeCurrentPosition(node);
            pane.getChildren().add(rectangle);
            pane.getChildren().add(rec);
            System.out.println(snake.count);


            System.out.println("Check is POSITIVE");
        }
        //  System.out.println(snakeHead.getLayoutBounds());

    }

    public void checkBoundsOut(Rectangle snakeHead) {
        if (snakeHead.getX() > 640) snakeHead.setX(0);
        if (snakeHead.getX() < 0) snakeHead.setX(640);
        if (snakeHead.getY() > 480) snakeHead.setY(0);
        if (snakeHead.getY() < 0) snakeHead.setY(480);
    }
}







