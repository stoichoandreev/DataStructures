package data.structures.patterns;

public class Triangle implements Shape {

    @Override
    public void draw(int sides) {
        System.out.println(String.format(Shape.shapeText, sides));
    }
}
