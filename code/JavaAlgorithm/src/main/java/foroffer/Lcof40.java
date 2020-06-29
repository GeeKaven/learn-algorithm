package foroffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcof40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }

        Queue<Integer> heap = new PriorityQueue<>(k, (a1, a2) -> Integer.compare(a2, a1));

        for (int item : arr) {
            if (heap.isEmpty() || heap.size() < k || item < heap.peek()) {
                heap.offer(item);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[heap.size()];
        int i = 0;
        for (Integer item : heap) {
            result[i] = item;
            i++;
        }
        return result;
    }
}
