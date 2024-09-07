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

class Solution02 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = mergeSortedArrays(nums1, nums2)
        val size = merged.size

        return if (size % 2 == 0) {
            // Even number of elements, median is the average of the two middle elements
            (merged[size / 2 - 1] + merged[size / 2]) / 2.0
        } else {
            // Odd number of elements, median is the middle element
            merged[size / 2].toDouble()
        }
    }

    private fun mergeSortedArrays(nums1: IntArray, nums2: IntArray): IntArray {
        val merged = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var k = 0

        // Merge the two arrays
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++]
            } else {
                merged[k++] = nums2[j++]
            }
        }

        // Copy any remaining elements from nums1
        while (i < nums1.size) {
            merged[k++] = nums1[i++]
        }

        // Copy any remaining elements from nums2
        while (j < nums2.size) {
            merged[k++] = nums2[j++]
        }

        return merged
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val solution = Solution02()
        println("median: ${solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))}")
        println()
        println("median: ${solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4))}")
        println()
    }
    println("$elapsed milliseconds")
}