package q03

import kotlin.system.measureTimeMillis

//3. Longest Substring Without Repeating Characters
//
//Given a string s, find the length of the longest
//substring
//without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
//

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        var left = 0
        val currentTrack = HashSet<Char>()

        for (right in s.indices) {
            while (currentTrack.contains(s[right])) {
                currentTrack.remove(s[left])
                left++
            }
            currentTrack.add(s[right])
            maxLength = maxOf(maxLength, right - left + 1)
        }
        return maxLength
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val solution = Solution()
        println("count ${solution.lengthOfLongestSubstring("abcabcbb")}")
        println("count ${solution.lengthOfLongestSubstring("bbbbb")}")
        println("count ${solution.lengthOfLongestSubstring("pwwkew")}")
    }
    println("$elapsed milliseconds")
}
