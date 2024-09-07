package q01

import kotlin.system.measureTimeMillis

class Solution {
    //    fun twoSum(nums: IntArray, target: Int): IntArray {
//        for (i in nums.indices) {
//            for (j in i + 1..<nums.size) {
//                if (nums[i] + nums[j] == target) {
//                    return listOf(i, j).toIntArray()
//                }
//            }
//        }
//        throw IllegalArgumentException("Invalid nums provided")
//    }
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()
        for (index in nums.indices) {
            val complement = target - nums[index]
            if (numMap.containsKey(complement)) {
                return intArrayOf(numMap[complement]!!, index)
            }
            numMap[nums[index]] = index
        }
        return intArrayOf()
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val solution = Solution()
        println("Case 1: ${solution.twoSum(nums = listOf(2, 7, 11, 15).toIntArray(), target = 9).toList()}")
        println("Case 2: ${solution.twoSum(nums = listOf(3, 2, 4).toIntArray(), target = 6).toList()}")
        println("Case 3: ${solution.twoSum(nums = listOf(3, 3).toIntArray(), target = 6).toList()}")
    }
    println("$elapsed milliseconds")
}