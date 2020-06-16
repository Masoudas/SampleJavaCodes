package SwingLibrary.Introduction;

import java.awt.*;

class AWTPoint {
    public static void main(String[] args) {
        // Used for indicating the position of a component,
        Point point = new Point();
    }
}

class AWTDimension {
    public static void main(String[] args) {
        // Used for representing the size of a component.
        Dimension dim = new Dimension();
    }
}

class AWTInsets {
    public static void main(String[] args) {
        // Represents the space around a component ().
        // using its constructor Insets(top, left, bottom, right)
        Insets insets = new Insets(5, 5, 10, 10);
    }
}

class AWTRectangle {
    public static void main(String[] args) {
        // An object of the Rectangle class defines the location and size of a component
        // in a Swing application
        // Size and location are also known as bounds of the component.
        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 10;
        rectangle.width = 20;
        rectangle.height = 12;

        Rectangle r3 = new Rectangle(new Point(10, 10), new Dimension(200, 100));
    }
}