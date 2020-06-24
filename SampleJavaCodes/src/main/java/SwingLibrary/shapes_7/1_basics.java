package SwingLibrary.shapes_7;

import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.*;

class basics {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(0, 0, 3, 3);
        PathIterator itr = rect.getPathIterator(null);
        

        while (!itr.isDone()) {
            double[] coord = new double[2];
            itr.currentSegment(coord);
            System.out.println("x is " + coord[0] + " and y is " + coord[1]);
            itr.next();

        }

        
        
    }
}