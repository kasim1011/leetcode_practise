package q02

import kotlin.system.measureTimeMillis

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution04 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // Dummy node to help in building the result list
        val dummyHead = ListNode(0)
        var p = l1
        var q = l2
        var current = dummyHead
        var carry = 0

        // Loop through both lists
        while (p != null || q != null || carry != 0) {
            // Sum the values of the current nodes and the carry
            val sum = (p?.`val` ?: 0) + (q?.`val` ?: 0) + carry
            carry = sum / 10  // Calculate carry for the next iteration

            // Add the current digit to the result list
            current.next = ListNode(sum % 10)
            current = current.next!!

            // Move to the next nodes, if available
            p = p?.next
            q = q?.next
        }

        // Return the next node after the dummy node, which is the head of the result list
        return dummyHead.next
    }
}

fun main() {
    val elapsed = measureTimeMillis {
        val l1e1 = ListNode(2)
        val l1e2 = ListNode(4)
        val l1e3 = ListNode(3)
        l1e1.next = l1e2
        l1e2.next = l1e3

        val l2e1 = ListNode(5)
        val l2e2 = ListNode(6)
        val l2e3 = ListNode(4)
        l2e1.next = l2e2
        l2e2.next = l2e3

        val solution = Solution04()
        val o1 = solution.addTwoNumbers(l1e1, l2e1)
        val o1List = o1.toList()
        println(o1List)

        //-----------------------

        val l3e1 = ListNode(0)
        val l4e1 = ListNode(0)

        val o3 = solution.addTwoNumbers(l3e1, l4e1)
        val o3List = o3.toList()
        println(o3List)

        //-----------------------

        val l5e1 = ListNode(2)
        val l5e2 = ListNode(4)
        val l5e3 = ListNode(9)
        l5e1.next = l5e2
        l5e2.next = l5e3

        val l6e1 = ListNode(9)
        val l6e2 = ListNode(9)
        l6e1.next = l6e2

        val o5 = solution.addTwoNumbers(l5e1, l6e1)
        val o5List = o5.toList()
        println(o5List)
    }
    println("$elapsed milliseconds")
}