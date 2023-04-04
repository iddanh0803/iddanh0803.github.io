package Bai1;

public class Geometry {
    public float Ssquare (float side ){
        float Sv = side*side;
        return Sv;
    }
    public float Csquare (float side){
        float Cv = 4*side;
        return Cv;
    }
    public float Srectangle (float length, float width){
        float Scn = length*width;
        return Scn;
    }
    public float Crectangle (float length, float width){
        float Ccn = 2*(length+width);
        return Ccn;
    }
}
