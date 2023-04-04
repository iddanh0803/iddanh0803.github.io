package Bai1;

import Bai1.Geometry;

public class Square extends Geometry {
    private float side;

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }
    public Square(float side){
        this.side = side;
    }

    public Square() {

    }
}
