class Solution:
    """
    Note: in Python 3 `i / 2` will return float number. 
    Use `//` to get the integer: `mid = (low + high) // 2`
    @param A: an integer rotated sorted array
    @param target: an integer to be searched
    @return: an integer
    """

    def search(self, A, target):
        # write your code here
        low = 0
        high = len(A) - 1
        while low <= high:
            mid = (low + high) // 2
            if A[mid] == target:
                return mid
            elif A[low] < A[mid]:
                if A[low] <= target and target < A[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if A[mid] < target and target <= A[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
