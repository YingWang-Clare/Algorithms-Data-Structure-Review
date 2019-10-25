# The classic version of binary search
def binary_search(nums, target):
    l = 0
    r = len(nums) - 1
    while l <= r:
        m = l + (r - l) / 2
        if nums[m] == target:
            return m
        if nums[m] > target:
            r = m - 1
        else:
            l = m + 1
    return -1

"""
    Binary search in 2D space, return the position of the target
    1 2   3  4
    5 6   7  8
    9 10 11 12
    target == 6
"""
def binary_search_2d_space(matrix, target):
    left = 0
    row = len(matrix)
    col = len(matrix[0])
    right = row * col - 1
    while left <= right:
        mid = left + (right - left) / 2
        r = mid / col
        c = mid % col
        if matrix[r][c] == target:
            return [r, c]
        if matrix[r][c] > target:
            right = mid - 1
        else:
            left = mid + 1
    return [-1, -1]

matrix = [[1,2,3,4], [5,6,7,8], [9,10,11,12]]
print(binary_search_2d_space(matrix, 14))
