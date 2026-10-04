public class VectorRenderer implements Renderer {
    @Override
    public String renderCircle(int id, double radius) {
        return "Vector render of Circle [ID=" + id + "] with radius " + radius;
    }

    @Override
    public String renderSquare(int id, double side) {
        return "Vector render of Square [ID=" + id + "] with side " + side;
    }
}
