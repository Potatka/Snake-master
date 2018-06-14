package sample;


import com.sun.javafx.font.directwrite.RECT;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Food;
import model.GameLoop;
import model.Node;
import model.Snake;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene;
        Pane pane = new Pane();
        Snake snake = new Snake();
        Food food = new Food();
        Rectangle snakeHead = snake.spawnFirstRectangle();
        snake.addRectangle(snakeHead);
        Circle foodNode = food.spawnFood();


        pane.getChildren().add(snakeHead);
        pane.getChildren().add(foodNode);


        //pane.setAlignment(Pos.TOP_CENTER);
        primaryStage.setTitle("Snake");


        primaryStage.setScene(scene = new Scene(pane, 640, 480));
        GameLoop loop = new GameLoop(scene, primaryStage, pane, foodNode, snake);
        primaryStage.setResizable(false);
        loop.startCycle(snake, food, snakeHead);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
