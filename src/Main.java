public class Main {
    public static void main(String[] args) {
        runDemo();
    }

    private static void runDemo() {
        int passed = 0;
        int total = 7;

        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();
        Renderer ascii = new AsciiRenderer();

        Circle circle1 = new Circle(1, 2.0, vector);
        String resT1 = circle1.execute();
        boolean passT1 = resT1.equals("Vector render of Circle [ID=1] with radius 2.0");
        if (passT1) passed++;
        printResult("T1", passT1, "Circle + VectorRenderer", resT1, "Vector render of Circle [ID=1] with radius 2.0");

        Circle circle2 = new Circle(1, 2.0, raster);
        String resT2 = circle2.execute();
        boolean passT2 = resT2.equals("Raster render of Circle [ID=1] with radius 2.0");
        if (passT2) passed++;
        printResult("T2", passT2, "Circle + RasterRenderer", resT2, "Raster render of Circle [ID=1] with radius 2.0");

        Square square1 = new Square(2, 3.0, vector);
        String resT3 = square1.execute();
        boolean passT3 = resT3.equals("Vector render of Square [ID=2] with side 3.0");
        if (passT3) passed++;
        printResult("T3", passT3, "Square + VectorRenderer", resT3, "Vector render of Square [ID=2] with side 3.0");

        Square square2 = new Square(2, 3.0, raster);
        String resT4 = square2.execute();
        boolean passT4 = resT4.equals("Raster render of Square [ID=2] with side 3.0");
        if (passT4) passed++;
        printResult("T4", passT4, "Square + RasterRenderer", resT4, "Raster render of Square [ID=2] with side 3.0");

        Circle switchCircle = new Circle(10, 2.0, vector);
        Circle refBefore = switchCircle;
        int idBefore = switchCircle.getId();
        double radiusBefore = switchCircle.getRadius();
        String beforeResult = switchCircle.execute();

        switchCircle.setImplementation(raster);

        Circle refAfter = switchCircle;
        int idAfter = switchCircle.getId();
        double radiusAfter = switchCircle.getRadius();
        String afterResult = switchCircle.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = (idBefore == idAfter) && (radiusBefore == radiusAfter);
        boolean correctExecution = beforeResult.equals("Vector render of Circle [ID=10] with radius 2.0") &&
                afterResult.equals("Raster render of Circle [ID=10] with radius 2.0");

        boolean passT5 = sameObject && stateUnchanged && correctExecution;
        if (passT5) passed++;
        System.out.println("T5 " + (passT5 ? "PASS" : "FAIL") + " sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged + " | before=<" + beforeResult + "> | after=<" + afterResult + ">");

        Circle circle3 = new Circle(1, 2.0, ascii);
        String resT6 = circle3.execute();
        boolean passT6 = resT6.equals("ASCII render of Circle [ID=1] with radius 2.0");
        if (passT6) passed++;
        printResult("T6", passT6, "Circle + AsciiRenderer", resT6, "ASCII render of Circle [ID=1] with radius 2.0");

        Square square3 = new Square(2, 3.0, ascii);
        String resT7 = square3.execute();
        boolean passT7 = resT7.equals("ASCII render of Square [ID=2] with side 3.0");
        if (passT7) passed++;
        printResult("T7", passT7, "Square + AsciiRenderer", resT7, "ASCII render of Square [ID=2] with side 3.0");

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void printResult(String testId, boolean pass, String details, String actual, String expected) {
        if (pass) {
            System.out.println(testId + " PASS | " + details + " | result=" + actual);
        } else {
            System.out.println(testId + " FAIL | " + details + " | actual=<" + actual + "> | expected=<" + expected + ">");
        }
    }
}
