/**
 *
 * 如果是找第 K 个最近的 Point: KthLargestElementInAnArray
    maxHeap,
    for (Point point: points) {
      distance = computeDistance(point.x, point.y)
      if (maxHeap.size() < k) {
        maxHeap.offer(new Cell(point, distance))
      } else {
        if (distance < maxHeap.peek()) {
          maxHeap.poll();
          maxHeap.offer(new Cell(point, distance))
        }
      }
    }
    return maxheap.peek().point
 */
public class KClosestPoints {
    class Cell {
        Point point;
        long distance;
        Cell(Point point, long distance) {
            this.point = point;
            this.distance = distance;
        }
    }
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        if (points == null || points.length == 0 || k <= 0) {
            return new Point[0];
        }
        k = Math.min(k, points.length);
        Queue<Cell> maxHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
          public int compare(Cell c1, Cell c2) {
            if (c1.distance == c2.distance) {
              if (c1.point.x == c2.point.x) {
                return c1.point.y < c2.point.y ? 1 : -1;
              }
              return c1.point.x < c2.point.x ? 1 : -1;
            }
            return c1.distance < c2.distance ? 1 : -1;
          }
        });
        for (int i = 0; i < k; ++i) {
            int distance = computeDistance(points[i].x - origin.x, points[i].y - origin.y);
            maxHeap.offer(new Cell(points[i], distance));
        }
        for (int i = k; i < points.length; ++i) {
            int distance = computeDistance(points[i].x - origin.x, points[i].y - origin.y);
            if (distance < maxHeap.peek().distance) {
                maxHeap.poll();
                maxHeap.offer(new Cell(points[i], distance));
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

    private long computeDistance(int x, int y) {
        // return x * x + y * y;
        return (long)(x) * (long)(x) + (long)(y) * (long)(y);
    }
}
