package SHAPES;

public class TestClass {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(1,2,3,4);
        Square s = new Square(1);
        Circle c = new Circle(6);
        Cylinder  cy = new Cylinder(-4);
        c.printProperties();
        s.printProperties();
        r.printProperties();
    }
}
