package SHAPES;

public class Rectangle extends Shape {
    private int length=1;
    private int width=1;

    public Rectangle(){
        super();
        length = 1;
        width = 1;
    }

    public Rectangle(int length, int width){
        super();
        setLength(length);
        setWidth(width);
    }

    public Rectangle(int x, int y, int length, int width){
        super(x,y);
        setLength(length);
        setWidth(width);
    }
    public int getLength(){
        return length;
    }

    public void setLength(int l){
        if(l <= 0){
            System.out.println("Error..length will remain "+length);
        }else{
            length = l;
        }
    }
    public int getWidth(){
        return length;
    }

    public void setWidth(int w){
        if(w <= 0){
            System.out.println("Error..width will remain "+width);
        }else{
            width = w;
        }
    }

    @Override
    public void printProperties() {
        super.printProperties();
        System.out.println("length = "+ length);
        System.out.println("width = "+ width);
        System.out.println("Area = "+ shapeArea());
    }

    @Override
    public int shapeArea() {
        return (length*width);
    }
}
