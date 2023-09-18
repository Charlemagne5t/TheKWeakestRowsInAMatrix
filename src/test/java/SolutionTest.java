import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void kWeakestRowsTest1() {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        int k = 3;
        int[] expected = {0, 2, 3};
        int[] actual = new Solution().kWeakestRows(mat, k);
        Arrays.sort(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void kWeakestRowsTest2() {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
        };
        int k = 2;
        int[] expected = {0, 2};
        int[] actual = new Solution().kWeakestRows(mat, k);
        Arrays.sort(actual);

        Assert.assertArrayEquals(expected, actual);
    }
}
