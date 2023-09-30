package SHAPES;

public class Square extends Shape{
    private int length;

    public Square(){
        super();
        length = 1;
    }

    public Square(int length){
        super();
        setLength(length);
    }

    public Square(int x, int y, int length){
        super(x,y);
        setLength(length);
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

    @Override
    public void printProperties() {
        super.printProperties();
        System.out.println("length = " + length);
        System.out.println("Area = "+ shapeArea());
    }

    @Override
    public int shapeArea() {
        return (length*length);
    }
}
