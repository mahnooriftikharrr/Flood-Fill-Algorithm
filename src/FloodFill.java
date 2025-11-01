import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

public class FloodFill {

    public static BufferedImage fill(BufferedImage img, Color fillColor, Point start, double thresh) {
        BufferedImage imageCopy = Utilities.copyImage(img);
        ImageWalker walker = new ImageWalker(img, start, thresh);

        Iterator<Point> iter = walker.iterator();

        while (iter.hasNext()){
            Point p = iter.next();

            imageCopy.setRGB(p.x, p.y, fillColor.getRGB());

        }
        return imageCopy;
    }

    public static BufferedImage gridFill(BufferedImage img, Color bgColor, Color gridColor,
                                         Point start, double thresh, int spacing){
        BufferedImage imageCopy = Utilities.copyImage(img);
        ImageWalker walker = new ImageWalker(img, start, thresh);

        Iterator<Point> iter = walker.iterator();

        while (iter.hasNext()){
            Point p = iter.next();
            if(p.x % spacing == 0 || p.y % spacing == 0){
                imageCopy.setRGB(p.x, p.y, gridColor.getRGB());
            }
            else{
                imageCopy.setRGB(p.x, p.y, bgColor.getRGB());
            }
        }
        return imageCopy;

    }


}
