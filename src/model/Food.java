package model;


import javafx.scene.shape.Circle;

public class Food {

    Circle foodCircle;
    int posY;
    int posX;

    public Food() {


    }

    public Circle spawnFood() {

        foodCircle = new Circle(15);
        foodCircle.relocate(150, 300);

        return foodCircle;
    }


}
