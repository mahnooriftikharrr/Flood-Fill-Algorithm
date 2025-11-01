import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImageWalker implements Iterable<Point> {

    private BufferedImage image;
    private double threshold;
    private Point start;
    private int startPixel;

    public ImageWalker (BufferedImage img, Point startPt, double thresh){
        this.image = img;
        this.start = startPt;
        this.threshold = thresh;
    }

    @Override
    public Iterator<Point> iterator() {
        return new BFSIterator();
    }

    private class BFSIterator implements Iterator<Point> {

        private Queue<Point> queue;
        private boolean[][] visited;
        private int startColor;

        private BFSIterator(){
            queue = new LinkedList<>();
            visited = new boolean[image.getHeight()][image.getWidth()];
            queue.add(start);
            startColor = image.getRGB(start.x,start.y);
            visited[start.x][start.y] = true;
        }


        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Point next() {
            if(queue.isEmpty()){
               throw new NoSuchElementException();
            };

            Point current = queue.poll();

            addNeighbors(current.x + 1, current.y);
            addNeighbors(current.x, current.y + 1);
            addNeighbors(current.x-1, current.y);
            addNeighbors(current.x, current.y-1);

            return current;

        }

        private void addNeighbors(int x, int y){
            if ( x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight()){
                return;
            }

            if (visited[x][y]) {
                return;
            }

            double diff = Utilities.computeDelta(image.getRGB(x,y), startColor);

            if (diff <= threshold){
                queue.offer(new Point(x, y));
                visited[x][y] = true;
            }

        }

    }

}
