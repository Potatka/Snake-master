package model;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by abyss on 8/17/2017.
 */
public class Node {

    private Rectangle firstNode;
    private Rectangle node;

    public static int count = 0;
    private int number;
    private double currentPosY;
    private double currentPosX;
    private double oldPosX;
    private double oldPosY;

    public Node(int number) {

        this.number = number;
    }

    public Rectangle spawnFirstRectangle() {
        firstNode = new Rectangle(10, 10, Color.GREEN);

        return firstNode;
    }

    public Rectangle spawnRectangle() {
        node = new Rectangle(10, 10);

        return node;
    }

    public Rectangle getRectangle() {
        return node;
    }

    public Rectangle getFirstRectangle() {
        return firstNode;
    }

    public void setOldPos(double posX, double posY) {
        oldPosX = posX;
        oldPosY = posY;
    }

    public void setCurrentPos(double posX, double posY) {
        currentPosX = posX;
        currentPosY = posY;

    }

    public double getCurrentPosY() {
        return currentPosY;
    }

    public double getCurrentPosX() {
        return currentPosX;
    }

    public double getOldPosX() {
        return oldPosX;
    }

    public double getOldPosY() {
        return oldPosY;
    }
}
