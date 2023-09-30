package SHAPES;

public class Circle extends Shape {
    private int radius=1;

    public Circle(){
      super();
      radius = 1;
    }

    public Circle(int radius){
        super();
        setRadius(radius);
    }

    public Circle(int x, int y, int radius){
        super(x,y);
        setRadius(radius);
    }
    public int getRadius(){
        return radius;
    }

    public void setRadius(int r){
        if(r <= 0){
            System.out.println("Error..radius will remain "+ radius);
        }else{
            radius = r;
        }
    }

    @Override
    public void printProperties() {
        super.printProperties();
        System.out.println("radius = " + radius);
        System.out.println("Area = " + shapeArea());
    }

    @Override
    public int shapeArea() {
        return (3*radius*radius);
    }
}
