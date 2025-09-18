import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    static final int TOTAL_RECTANGLES = 10;
    static ArrayList<Rectangle> rects = new ArrayList<>();
    static BigRectangleFilter filter;

    public static void main(String[] args) {
        int counter = 0;

        createDataSet();
        filter = new BigRectangleFilter();

        System.out.println("Rectangles with perimeter > 10:\n");
        for (Rectangle rec : rects) {
            if (filter.accept(rec)) {
                counter++;
                int p = 2 * (rec.width + rec.height);
                System.out.printf(
                        "Rectangle #%2d  w=%d\th=%d\tP=%d%n",
                        counter, rec.width, rec.height, p
                );
            }
        }
        System.out.println("\n" + counter + " accepted out of " + rects.size());
    }

    private static void createDataSet() {
        rects.clear();

        rects.add(new Rectangle(0, 0, 1, 1));
        rects.add(new Rectangle(0, 0, 2, 2));
        rects.add(new Rectangle(0, 0, 3, 2));
        rects.add(new Rectangle(0, 0, 4, 2));
        rects.add(new Rectangle(0, 0, 5, 1));
        rects.add(new Rectangle(0, 0, 1, 5));
        rects.add(new Rectangle(0, 0, 6, 1));
        rects.add(new Rectangle(0, 0, 2, 3));
        rects.add(new Rectangle(0, 0, 7, 2));
        rects.add(new Rectangle(0, 0, 0, 0));
    }
}
