public class SortingsAlgo {
    /*
        What are sorting algorithms?
            a. Selection Sort
            b. Merge Sort
            c. Quick Sort
            d. Bubble Sort
            e. Bucket Sort
            f. Patient Sort
            g. Smooth Sort
            h. Cocktail Sort
            i. ...
     */

    /* a. Selection Sort
            Time complexity: O(n^2)
            Space complexity: O(1)
    */
    public void selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
    }
    // helper function to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /*
        b. Merge Sort: divide + merge
            Time complexity: O(nlogn)
            Space complexity: O(n), extra space in merge()
    */
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        nums = divide(nums, 0, nums.length - 1);
        return nums;
    }
    private int[] divide(int[] nums, int l, int r) {
        // base case: there is only one element in the array
        if (l == r) {
            return new int[] {nums[l]};
        }
        // recursive rule:
        int m = l + (r - l) / 2;
        int[] leftSub = divide(nums, l, m);
        int[] rightSub = divide(nums, m + 1, r);
        int[] merged = merge(leftSub, rightSub);
        return merged;
    }
    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < right.length) {
            res[k++] = right[j++];
        }
        return res;
    }

    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        quickHelper(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickHelper(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = 0;
        for (int p = r; p >= l; p--) {
            int pivot = nums[p];
            int i = l;
            int j = p - 1;
            while (i <= j) {
                if (nums[i] < pivot) {
                    i++;
                } else {
                    swap(nums, i, j);
                    j--;
                }
            } // i > j
            swap(nums, i, p);
            m = i;
        }
        quickHelper(nums, l, m);
        quickHelper(nums, m + 1, r);
    }

    public static void main(String[] args) {
        SortingsAlgo test = new SortingsAlgo();
        int[] nums = {4,6,5,2,3};
        nums = test.quickSort(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}