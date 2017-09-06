/**
 *
 */
public class KClosestPoints {
    class Cell implements Comparable<Cell> {
        Point point;
        Point origin;
        long distance;
        Cell(Point point, Point origin) {
            this.point = point;
            this.origin = origin;
            this.distance = computeDistance((long)point.x - (long)origin.x, 
                                            (long)point.y - (long)origin.y);
        }
        @Override
        public int compareTo(Cell cell) {
            if (this.distance == cell.distance) {
                if (this.point.x == cell.point.x) {
                    return this.point.y <= cell.point.y ? 1 : -1;
                }
                return this.point.x < cell.point.x ? 1 : -1;
            }
            return this.distance < cell.distance ? 1 : -1;
        }
    }
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if (points == null || points.length == 0 || k <= 0) {
            return new Point[0];
        }
        k = Math.min(k, points.length);
        Queue<Cell> maxHeap = new PriorityQueue<Cell>();
        for (int i = 0; i < k; ++i) {
            maxHeap.offer(new Cell(points[i], origin));
        }
        for (int i = k; i < points.length; ++i) {
            if (computeDistance((long)points[i].x - (long)origin.x, (long)points[i].y - (long)origin.y) < maxHeap.peek().distance) {
                maxHeap.poll();
                maxHeap.offer(new Cell(points[i], origin));
            }
        }
        Point[] ret = new Point[k];
        Cell cur = null;
        while (!maxHeap.isEmpty()) {
            cur = maxHeap.poll();
            ret[--k] = new Point(cur.point.x, cur.point.y);
        }
        return ret;
    }
    
    private long computeDistance(long x, long y) {
        return x * x + y * y;
        // return (long)(x) * (long)(x) + (long)(y) * (long)(y); 
    }
}
