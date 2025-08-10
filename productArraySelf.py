# Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

# The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

# You must write an algorithm that runs in O(n) time and without using the division operation.

import math
class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        answer = [1] * len(nums)
        left = 1
        right = 1
        
        # do not affect the element in the question -> the left value is changed only after we update the product
        for number_index in range(len(nums)):
            answer[number_index] *= left # update the product of the left ones at the moment
            left *= nums[number_index] # update the left product
            
        # do not affect the element in the question -> occurs the same as the left value
        for number_index in range(len(nums) - 1, -1, -1):
            answer[number_index] *= right
            right *= nums[number_index]
            
        return answer