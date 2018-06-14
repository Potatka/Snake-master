package model;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abyss on 8/17/2017.
 */
public class Snake {

    List<Node> nodeList;
    List<Rectangle> rectangleList;
    Rectangle rectangle;
    Rectangle firstRectangle;
    Rectangle secondRectangle;
    Node firstNode;
    Node node;
    int count = 0;

    public Snake() {
        firstNode = new Node(1);
        count++;
        nodeList = new ArrayList<>(10);
        rectangleList = new ArrayList<>(10);
        addNode(firstNode);

    }

    public void addNode(Node node) {
        nodeList.add(node);

    }

    public void addRectangle(Rectangle rectangle) {
        rectangleList.add(rectangle);
    }

    public Node spawnNewNode() {
        node = new Node(count);
        count++;
        addNode(node);
        return node;

    }

    public Node getNode(int i) {


        return nodeList.get(i);
    }

    public Rectangle spawnFirstRectangle() {
        Node currentNode = nodeList.get(0);
        Rectangle node = currentNode.spawnFirstRectangle();
        currentNode.setCurrentPos(node.getX(), node.getY());

        return node;
    }

    public void writeCurrentPosition(Node node) {
        node.setCurrentPos(node.getRectangle().getX(), node.getRectangle().getY());

    }

    public void writeCurrentPosition(Rectangle rectangle) {
        nodeList.get(0).setCurrentPos(rectangle.getX(), rectangle.getY());

    }

    public void followSnakeHead(int a, int b) {
        Node firstNode = nodeList.get(0);
        Node secondNode = nodeList.get(1);

        firstRectangle = firstNode.getRectangle();
        secondRectangle = secondNode.getRectangle();

        secondRectangle.relocate(firstNode.getCurrentPosX(), firstNode.getCurrentPosY());


    }
}