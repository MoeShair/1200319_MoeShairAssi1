package com.example.a1200319_moeshairassi1.modle;

public class Cylinder {
    private double volume;
    private double radius;
    private double height;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double volume, double radius, double height) {
        this.volume = volume;
        this.radius = radius;
        this.height = height;

        if(this.volume==-1){
            this.volume= (Math.PI)*height* Math.pow(radius,2);
        }
        else if(this.radius==-1){
            this.radius= Math.sqrt(volume/(Math.PI * height));
        }
        else if(this.height==-1){
            this.height= volume/(Math.PI* Math.pow(radius,2));
        }
    }
}
