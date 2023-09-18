import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).thenComparing((int[] a) -> a[0]));

        for (int i = 0; i < mat.length; i++) {
            int index = binarySearch(mat[i]);
            priorityQueue.add(new int[]{i, index});
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }

        return result;
    }

    public int binarySearch(int[] row) {

        int left = 0;
        int right = row.length - 1;
        if (row[left] == 0) {
            return 0;
        }
        if (row[right] == 1) {
            return row.length;
        }

        int mid = left + (right - left) / 2;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (row[mid] == 0 && mid > 0 && row[mid - 1] == 1) {
                return mid;
            }

            if (row[mid] == 1 && mid < row.length - 1 && row[mid + 1] == 0) {
                return mid + 1;
            }

            if (row[mid] == 0) {
                right = mid - 1;
            }

            if (row[mid] == 1) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
