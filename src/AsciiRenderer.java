public class AsciiRenderer implements Renderer {
    @Override
    public String renderCircle(int id, double radius) {
        return "ASCII render of Circle [ID=" + id + "] with radius " + radius;
    }

    @Override
    public String renderSquare(int id, double side) {
        return "ASCII render of Square [ID=" + id + "] with side " + side;
    }
}