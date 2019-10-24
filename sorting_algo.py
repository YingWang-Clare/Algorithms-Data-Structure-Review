# a. selection sort:
def selection_sort(nums):
    for i in range(len(nums)):
        min_id = i
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[min_id]:
                min_id = j
        # swap:
        nums[i], nums[min_id] = nums[min_id], nums[i]

# b. merge sort:
def merge_sort(nums):
    if len(nums) > 1:
        mid = len(nums) / 2
        left_half = nums[:mid]
        right_half = nums[mid:]
        merge_sort(left_half)
        merge_sort(right_half)
        i = j = k = 0
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                nums[k] = left_half[i]
                i += 1
            else:
                nums[k] = right_half[j]
                j += 1
            k += 1
        while i < len(left_half):
            nums[k] = left_half[i]
            i += 1
            k += 1
        while j < len(right_half):
            nums[k] = right_half[j]
            j += 1
            k += 1

# c. quick sort
def quick_sort(nums, lo, hi):
    if lo <= hi:
        m = quick_divide(nums, lo, hi)
        quick_sort(nums, lo, m - 1)
        quick_sort(nums, m + 1, hi)

def quick_divide(nums, lo, hi):
    m = 0
    for p in range(hi, lo - 1, -1):
        i = lo
        j = p - 1
        while i <= j:
            if nums[i] < nums[p]:
                i += 1
            else:
                nums[i], nums[j] = nums[j], nums[i]
                j -= 1
        # i > j
        nums[i], nums[p] = nums[p], nums[i]
        m = i
    return m

nums = [4,6,5,2,3,1,7,9]
quick_sort(nums, 0, len(nums) - 1)
print(nums)