package com.example.a1200319_moeshairassi1.modle;

public class Cuboid {

    private double volume;
    private double length;
    private double width;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double height;

    public Cuboid(double volume, double length, double width, double height) {
        this.volume = volume;
        this.length = length;
        this.width = width;
        this.height = height;

        if(this.volume==-1){
            this.volume= length*width*height;
        }
        else if(this.length==-1){
            this.length= volume/(width*height);
        }
        else if(this.width==-1){
            this.width= volume/(length*height);
        }
        else if(this.height==-1){
            this.height= volume/(length*width);
        }
    }
}
