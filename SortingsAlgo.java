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

    // a. Selection Sort
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


    public static void main(String[] args) {

    }
}