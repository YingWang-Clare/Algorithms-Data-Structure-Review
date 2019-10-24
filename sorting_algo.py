# a. selection sort:
def selection_sort(nums):
    for i in range(len(nums)):
        min_id = i
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[min_id]:
                min_id = j
        # swap:
        nums[i], nums[min_id] = nums[min_id], nums[i]


nums = [4,6,5,2,3]
selection_sort(nums)
print(nums)