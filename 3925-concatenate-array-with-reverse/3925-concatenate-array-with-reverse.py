class Solution(object):
    def concatWithReverse(self, nums):

        n = len(nums)
        ans = [0] * (2 * n)

        for i in range(n):
            ans[i] = nums[i]
            ans[n + i] = nums[n - 1 - i]

        return ans