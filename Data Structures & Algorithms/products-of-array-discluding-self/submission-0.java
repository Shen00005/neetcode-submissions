class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int[] output = new int[nums.length];

        left.add(1);
        right.add(1);

        for (int i = 1; i < nums.length; i++) {
            int mul = left.get(i - 1) * nums[i - 1];
            left.add(mul);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            int mul = right.get(0) * nums[i + 1];
            right.add(0, mul);
        }
        
        for (int i=0; i < nums.length; i++) {
            output[i] = left.get(i)*right.get(i);
        }

        return output;
        
    }
}  
