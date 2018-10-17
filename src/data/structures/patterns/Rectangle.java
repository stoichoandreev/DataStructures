package data.structures.patterns;

public class Rectangle implements Shape {

    @Override
    public void draw(int sides) {
        System.out.println(String.format(Shape.shapeText, sides));
    }
}
