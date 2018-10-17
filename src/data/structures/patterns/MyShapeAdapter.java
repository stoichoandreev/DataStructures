package data.structures.patterns;

public class MyShapeAdapter implements Shape {

    @Override
    public void draw(int sides) {
        if (sides == MyFactory.CIRCLE_NUMBER) {
            AdvancedShape advancedShape = new Circle();
            advancedShape.drawCircle();
        } else {
            Shape originShape = MyFactory.createShape(sides);
            originShape.draw(sides);
        }
    }
}
