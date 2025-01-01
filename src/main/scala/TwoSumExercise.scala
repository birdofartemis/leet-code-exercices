package com.leet.exercice

import scala.annotation.tailrec

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
object TwoSumExercise {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val sortedList = nums.zipWithIndex.sortBy(_._1)

    @tailrec
    def aux(ascIndex: Int, decIndex: Int): Array[Int] = {
      (sortedList(ascIndex), sortedList(decIndex)) match {
        case ((n1, _), (n2, _)) if n1 + n2 > target => aux(ascIndex, decIndex - 1)
        case ((n1, _), (n2, _)) if n1 + n2 < target => aux(ascIndex + 1, decIndex)
        case ((_, index1), (_, index2)) => Array(index1, index2)
      }
    }

    aux(0, nums.length - 1)
  }

}

