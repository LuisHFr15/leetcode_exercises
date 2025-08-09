# 
#  This code represents the leetcode exercise 'Longest Substring Without Repeating Characters'.
#  

class Solution:
  def lengthOfLongestSubstring(self, s: str) -> int:
    length_string = len(s)
    longest_substring_length = 0
    char_set = set()
    left_char_index = 0
    
    for right_char_index in range(length_string):
      if s[right_char_index] not in char_set:
        char_set.add(s[right_char_index])
        longest_substring_length = max(longest_substring_length, right_char_index - left_char_index + 1)
      else:
        while s[right_char_index] in char_set:
          char_set.remove(s[left_char_index])
          left_char_index += 1
        char_set.add(s[right_char_index])
    
    return longest_substring_length

      


sol = Solution()

ret = sol.lengthOfLongestSubstring("dvdf")
print()
print(ret)