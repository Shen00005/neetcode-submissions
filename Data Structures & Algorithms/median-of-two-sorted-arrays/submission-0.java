class Solution {

    public void insertElement(int[] main, int[] sortedList, int main_index, int s_index) {
        main[main_index] = sortedList[s_index];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n = nums1.length;
         int m = nums2.length;

         int[] L = new int[n+m];

         int i = 0, j = 0;

         while (i+j <= (n+m)/2) {
            if (i == n) {
                insertElement(L, nums2, i+j, j);
                j++;
                continue;
            } else if (j == m) {
                insertElement(L, nums1, i+j, i);
                i++;
                continue;
            }


            if (nums1[i] < nums2[j]) {
                insertElement(L, nums1, i+j, i);
                i++;
            } else {
                insertElement(L, nums2, i+j, j);
                j++;
            }
         }
        
         int total = n + m;
         if (total % 2 == 1) {
            return L[total / 2];
         } else {
            double one = L[(total / 2) - 1];
            double two = L[total / 2];
            return (one + two) / 2;
         }


    }
}
