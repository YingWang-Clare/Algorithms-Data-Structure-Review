import java.util.*;

public class BinarySearch {
    /*
        The classic version of binary search, exit until left > right.
        If the target exists, return the index of the target
        Otherwise, return -1.

        Time complexity: O(log n)
        Space complexity: O(1)
    */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
        Binary search in 2D space, return the position of the target
        1 2   3  4
        5 6   7  8
        9 10 11 12
        target == 6
    */
    public int[] binarySearchInTwoDSpace(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) {
                return new int[] {r, c};
            }
            if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }

    /*
        Find an element in the array that is closest to the target number.
        1 2 3 8 9  target == 4  return:2
    */
    public int findClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) { // one step early stop
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // post-processing
        if (Math.abs(target - nums[left]) > Math.abs(target - nums[right])) {
            return right;
        } else {
            return left;
        }
    }

    /*
        Return the index of the first occurrence of an element.
        4 5 5 5 5 5 5 5 5   target == 5  return: 1

    */
    public int getFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /*
        Return the index of the last occurrence of an element
        4 5 5 5 6 6 7   target == 5  return 3
    */
    public int getLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /*
        Find k elements in the array closest to the target number.
        1 2 3 8 9   target == 4 k == 3  return [1,2,3]
        Time: O(log n + k)
    */
    public List<Integer> kClosestElements(int[] nums, int target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k <= 0) {
            return res;
        }
        // do binary search to find the element closest to the target: log n
        int left = 0;
        int right = nums.length - 1;
        int split = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                split = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (split == -1) {
            if (Math.abs(nums[left] - target) > Math.abs(nums[right] - target)) {
                split = right;
            } else {
                split = left;
            }
        }
        res.add(nums[split]);
        // search and compare from both sides on the split point: k
        int i = 1;
        int j = 1;
        while (split - i >= 0 && split + j < nums.length && res.size() < k) {
            if (Math.abs(nums[split - i] - target) > Math.abs(nums[split + j] - target)) {
                res.add(nums[split + j]);
                j++;
            } else {
                res.add(nums[split - i]);
                i++;
            }
        }
        while (split - i >= 0 && res.size() < k) {
            res.add(nums[split - i]);
            i++;
        }
        while (split + j < nums.length && res.size() < k) {
            res.add(nums[split + j]);
            j++;
        }
        return res;
    }
    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int[] nums = {1,2,3,8,9};
        List<Integer> res = test.kClosestElements(nums, 4, 2);
        for (int n : res) {
            System.out.println(n);
        }
        // System.out.println(res);
    }
}