package SHAPES;

public abstract class Shape {
    private int xCoord;
    private int yCoord;

    public Shape(){
        xCoord = 1;
        yCoord = 1;
    }

    public Shape(int x, int y){
        setxCoord(x);
        setyCoord(y);
    }
    public int getxCoord(){
        return xCoord;
    }

    public void setxCoord(int l){
        if(l <= 0){
            System.out.println("Error..xCoord will remain "+xCoord);
        }else{
            xCoord = l;
        }
    }
    public int getyCoord(){
        return yCoord;
    }

    public void setyCoord(int w){
        if(w <= 0){
            System.out.println("Error..width will remain "+yCoord);
        }else{
            yCoord = w;
        }
    }

    public void printProperties(){
        System.out.println("xCoord = "+xCoord);
        System.out.println("yCoord = "+yCoord);
    }

    public abstract int shapeArea();
}
