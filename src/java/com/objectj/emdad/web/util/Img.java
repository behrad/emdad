package com.objectj.emdad.web.util;

/**
 * Created by IntelliJ IDEA.
 * User: Behrad
 * Date: Mar 6, 2004
 * Time: 1:47:08 PM
 * To change this template use Options | File Templates.
 */
public class Img {

    private String name;
    private int azX;
    private int taX;
    private int azY;
    private int taY;
    private int level;

    public Img(String name, int azX, int taX, int azY, int taY, int level) {
        this.azX = azX;
        this.azY = azY;
        this.level = level;
        this.name = name;
        this.taX = taX;
        this.taY = taY;
    }

    public Img(String name, int azX, int taX, int azY, int taY) {
        this.azX = azX;
        this.azY = azY;
        this.name = name;
        this.taX = taX;
        this.taY = taY;
    }

    public int getAzX() {
        return azX;
    }

    public int getAzY() {
        return azY;
    }

    public String getName() {
        return name;
    }

    public int getTaX() {
        return taX;
    }

    public int getTaY() {
        return taY;
    }

    public void setAzX(int azX) {
        this.azX = azX;
    }

    public void setAzY(int azY) {
        this.azY = azY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaX(int taX) {
        this.taX = taX;
    }

    public void setTaY(int taY) {
        this.taY = taY;
    }

     public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRelatedWith( Img image ) {
        return (azX <= image.getAzX()) && (taX > image.getAzX()) && (azY < image.getTaY()) && (taY >= image.getTaY()) ||
          (azX <= image.getAzX()) && (taX > image.getAzX()) && (azY <= image.getAzY()) && (taY > image.getAzY()) ||
          (azX < image.getTaX()) && (taX >= image.getTaX()) && (azY < image.getTaY()) && (taY >= image.getTaY()) ||
          (azX < image.getTaX()) && (taX >= image.getTaX()) && (azY <= image.getAzY()) && (taY > image.getAzY()) ||
          (azX >= image.getAzX()) && (taX <= image.getTaX()) && (azY >= image.getAzY()) && (taY <= image.getTaY() );
    }
}
