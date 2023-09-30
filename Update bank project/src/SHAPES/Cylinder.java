package SHAPES;

public class Cylinder extends Circle {
    private int height = 1;

    public Cylinder(){
        super();
        height = 1;
    }

    public Cylinder(int height){
        super();
        setHeight(height);
    }
    public Cylinder(int radius, int height){
        super(radius);
        setHeight(height);
    }



    public Cylinder(int x, int y, int radius, int height){
        super(x,y,radius);
        setHeight(height);
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int h){
        if(h <= 0){
            System.out.println("Error..height will remain " + height);
        }else{
            height = h;
        }
    }

    public void printProperties() {
        super.printProperties();
        System.out.println("radius = " + height);
        System.out.println("Area = " + shapeArea());
    }

    @Override
    public int shapeArea() {
        return (3*getRadius()*getRadius()*height);
    }

}
