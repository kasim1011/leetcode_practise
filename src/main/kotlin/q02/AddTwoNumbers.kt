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

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val l1List = l1.toList()
        val l2List = l2.toList()

        val lesserList = if (l1List.size < l2List.size) l1List else l2List
        val greaterList = if (l1List.size > l2List.size) l1List else l2List

        var carry = 0
        var lastIndex = 0

        for (i in lesserList.indices) {
            lastIndex = i
            val total = carry + (l1List.getOrNull(i) ?: 0) + (l2List.getOrNull(i) ?: 0)
            carry = total / 10
            greaterList[i] = total % 10
        }

        lastIndex++
        while (carry > 0 && lastIndex < greaterList.size) {
            val total = carry + (greaterList.getOrNull(lastIndex) ?: 0)
            carry = total / 10
            greaterList[lastIndex] = total % 10
            lastIndex++
        }

        if (carry > 0) {
            greaterList.add(carry)
        }

        greaterList.reverse()
        return greaterList.toListNode()
    }
}

fun ListNode?.toList(): ArrayList<Int> {
    val list = ArrayList<Int>(15)
    var listNode = this
    while (listNode != null) {
        list.add(listNode.`val`)
        listNode = listNode.next
    }
    return list
}

fun ArrayList<Int>.toListNode(): ListNode? {
    if (this.isEmpty()) return null

    var prev: ListNode? = null
    for (i in this) {
        val listNode = ListNode(i)
        listNode.next = prev
        prev = listNode
    }
    return prev
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

        val solution = Solution()
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