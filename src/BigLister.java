import java.awt.Rectangle;
import java.util.ArrayList;

public class BigLister implements Filter {

    @Override
    public boolean accept(Object x) {
        Rectangle rect = (Rectangle) x;
        double perimeter = 2 * (rect.getWidth() + rect.getHeight());
        return perimeter > 10;
    }

    public static void main(String[] args) {
        // Create an ArrayList of Rectangles
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        // Add some rectangles with different perimeters
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(7, 1));
        rectangles.add(new Rectangle(1, 5));
        rectangles.add(new Rectangle(3, 6));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 9));
        rectangles.add(new Rectangle(1, 15));
        rectangles.add(new Rectangle(1, 3));

        // Create a BigLister instance
        BigLister bigLister = new BigLister();

        // Use the collectAll method to list rectangles with big perimeters
        Object[] bigRectangles = collectAll(rectangles.toArray(), bigLister);

// Print the big rectangles
        for (Object obj : bigRectangles) {
            Rectangle rect = (Rectangle) obj; // Cast each object to Rectangle
            double perimeter = 2 * (rect.getWidth() + rect.getHeight());
            System.out.println("Rectangle with accepted perimeter: " + perimeter );
        }
    }

    // Method to collect all objects accepted by the given filter
    public static Object[] collectAll(Object[] objects, Filter filter) {
        ArrayList<Object> acceptedObjects = new ArrayList<>();

        for (Object obj : objects) {
            if (filter.accept(obj)) {
                acceptedObjects.add(obj);
            }
        }

        return acceptedObjects.toArray();
    }
}
