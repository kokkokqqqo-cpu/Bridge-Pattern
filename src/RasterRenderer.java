public class RasterRenderer implements Renderer {
    @Override
    public String renderCircle(int id, double radius) {
        return "Raster render of Circle [ID=" + id + "] with radius " + radius;
    }

    @Override
    public String renderSquare(int id, double side) {
        return "Raster render of Square [ID=" + id + "] with side " + side;
    }
}
