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

class Solution02 {
    fun lengthOfLongestSubstring(s: String): Int {
        // Array to store the last index of each character
        // e.g if we have seen 'a' at 5th position on last time than lastSeenWindow[97] will be 5
        val lastSeenWindow = IntArray(128) { -1 }
        var maxLength = 0
        var left = 0

        for (right in s.indices) {
            // Current character at the 'right' position
            val char = s[right]
            // Move the 'left' pointer to exclude characters we've already seen
            left = maxOf(left, lastSeenWindow[char.code] + 1)
            // Update the maximum length if this window is larger than the previous one
            maxLength = maxOf(maxLength, right - left + 1)
            // Update where we last saw this character
            lastSeenWindow[char.code] = right
        }

        return maxLength
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val solution = Solution02()
        println("count ${solution.lengthOfLongestSubstring("abcabcbb")}")
        println("count ${solution.lengthOfLongestSubstring("bbbbb")}")
        println("count ${solution.lengthOfLongestSubstring("pwwkew")}")
    }
    println("$elapsed milliseconds")
}
