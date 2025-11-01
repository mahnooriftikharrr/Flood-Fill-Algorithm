import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class iBFSIteratorTest {

    @Test
    public void testIterator1() throws Exception {
        List<Point> expected = List.of(
                new Point(0,3),
                new Point(1,3),
                new Point(0,2),
                new Point(2,3),
                new Point(1,2),
                new Point(0,1),
                new Point(3,3),
                new Point(0,0),
                new Point(3,2),
                new Point(1,0),
                new Point(3,1),
                new Point(2,0),
                new Point(3,0)
        );

        BufferedImage img = ImageIO.read(new File("test4x4.png") );
        ImageWalker w = new ImageWalker(img, new Point(0,3), 0.2);
        Iterator<Point> iter = w.iterator();
        ArrayList<Point> results = new ArrayList<>(20);
        while( iter.hasNext() ) {
            Point p = iter.next();
            results.add(p);
        }

        assertEquals(expected, results);
    }
}
