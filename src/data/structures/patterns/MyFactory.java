package data.structures.patterns;

public class MyFactory {

    public static final int CIRCLE_NUMBER = 0;
    public static final int TRIANGLE_SIDE_NUMBER = 3;
    public static final int RECTANGLE_SIDE_NUMBER = 4;

    public static Shape createShape(int sides) {
        final Shape shape;
        switch (sides) {
            case TRIANGLE_SIDE_NUMBER:
                shape = new Triangle();
                break;
            case RECTANGLE_SIDE_NUMBER:
                shape = new Rectangle();
                break;
            default:
                throw new IllegalArgumentException("MyFactory can not provide instance if shape with " + sides + "sides");
        }

        return shape;
    }
}
