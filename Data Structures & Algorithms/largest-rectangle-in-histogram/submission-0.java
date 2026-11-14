class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int largest = 0;

        for (int i = 0; i < n; i++) {
            int j = i-1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        for (int i = 0; i < n; i++) {
            int rec_size = heights[i] * (right[i] - left[i] - 1);
            largest = Math.max(largest, rec_size);
        }
        return largest;
    }
}
