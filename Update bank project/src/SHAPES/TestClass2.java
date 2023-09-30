package SHAPES;

import java.util.Scanner;

public class TestClass2 {
    public static void main(String[] args) {
        Shape s1;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 12) {
            System.out.print(" 1-Circle\n 2-Square\n 3-Rectangle\n 4-Cylinder\n What shape would you like to draw?: ");
            choice = sc.nextInt();
            s1 = switch (choice) {
                case 1 -> new Circle();
                case 2 -> new Square();
                case 3 -> new Rectangle();
                case 4 -> new Cylinder();
                default -> null;
            };
            if (s1 instanceof Cylinder) {
                System.out.println("xCoord: " + s1.getxCoord());
                System.out.println("yCoord: " + s1.getyCoord());
                System.out.println("xCoord: " + ((Cylinder) s1).getRadius()); //Or ((Circle)s1).getRadius();
                System.out.println("xCoord: " + ((Cylinder) s1).getHeight());
                System.out.println("Area: " + s1.shapeArea());
            } else if (s1 instanceof Circle) {
                System.out.println("xCoord: " + s1.getxCoord());
                System.out.println("yCoord: " + s1.getyCoord());
                System.out.println("Radius: " + ((Circle) s1).getRadius());
                System.out.println("Area: " + s1.shapeArea());
            } else if (s1 instanceof Rectangle) {
                System.out.println("xCoord: " + s1.getxCoord());
                System.out.println("yCoord: " + s1.getyCoord());
                System.out.println("Length: " + ((Rectangle) s1).getLength());
                System.out.println("Width: " + ((Rectangle) s1).getWidth());
                System.out.println("Area: " + s1.shapeArea());
            } else if (s1 instanceof Square) {
                System.out.println("xCoord: " + s1.getxCoord());
                System.out.println("yCoord: " + s1.getyCoord());
                System.out.println("Length: " + ((Square) s1).getLength());
                System.out.println("Area: " + s1.shapeArea());
            } else {
                System.out.println("NulL object....");
            }
        }

    }
}