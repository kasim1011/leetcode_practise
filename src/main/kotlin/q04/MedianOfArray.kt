package q04

import kotlin.system.measureTimeMillis

//4. Median of Two Sorted Arrays
//Hard
//Topics
//Companies
//
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//The overall run time complexity should be O(log (m+n)).
//
//
//
//Example 1:
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//
//Example 2:
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
//
//Constraints:
//
//nums1.length == m
//nums2.length == n
//0 <= m <= 1000
//0 <= n <= 1000
//1 <= m + n <= 2000
//-106 <= nums1[i], nums2[i] <= 106
//

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Ensure nums1 is the smaller array
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

//        println("nums1: ${nums1.toList()}")
//        println("nums2: ${nums2.toList()}")

        val m = nums1.size
        val n = nums2.size

//        println("m: $m")
//        println("n: $n")

        var low = 0
        var high = m

        while (low <= high) {
//            println("low: $low")
//            println("high: $high")

            val partition1 = (low + high) / 2
            val partition2 = (m + n + 1) / 2 - partition1

//            println("partition1: $partition1")
//            println("partition2: $partition2")

            val maxLeft1 = if (partition1 == 0) Int.MIN_VALUE else nums1[partition1 - 1]
            val minRight1 = if (partition1 == m) Int.MAX_VALUE else nums1[partition1]

//            println("maxLeft1: $maxLeft1")
//            println("minRight1: $minRight1")

            val maxLeft2 = if (partition2 == 0) Int.MIN_VALUE else nums2[partition2 - 1]
            val minRight2 = if (partition2 == n) Int.MAX_VALUE else nums2[partition2]

//            println("maxLeft2: $maxLeft2")
//            println("minRight2: $minRight2")

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeft1, maxLeft2).toDouble() + minOf(minRight1, minRight2).toDouble()) / 2
                } else {
                    maxOf(maxLeft1, maxLeft2).toDouble()
                }
            } else if (maxLeft1 > minRight2) {
                // Move towards the left in nums1
                high = partition1 - 1
            } else {
                // Move towards the right in nums1
                low = partition1 + 1
            }
        }

        throw IllegalArgumentException("Input arrays are not sorted")
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val solution = Solution()
        println("median: ${solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))}")
        println()
        println("median: ${solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))}")
        println()
    }
    println("$elapsed milliseconds")
}