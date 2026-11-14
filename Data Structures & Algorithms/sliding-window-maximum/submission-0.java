public class MapQueue {
    private Map<Integer, Integer> map = new HashMap<>();
    private PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

    public void put(int x, int y) {
        map.put(x, y);
        pq.offer(new int[]{x, y});
    }

    public void remove(int x) {
        map.remove(x);
    }

    public int[] poll() {
        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int x = top[0];
            int y = top[1];

            if (map.containsKey(x) && map.get(x) == y) {
                
                return top;
            }

            pq.poll();
        }
        return null;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] results = new int[nums.length-k+1];
        MapQueue mq = new MapQueue();

        for (int i = 0; i < k; i++) {
            mq.put(i, nums[i]);
        }

        int index = 0;
        while (index < nums.length - k+1 ) {
            int[] top = mq.poll();
            results[index] = top[1];

            if (index+k < nums.length) {
                mq.put(index+k, nums[index+k]);
            } 

            mq.remove(index);
            index++;
        }
        return results;

    }
}
