class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            diffMap[int]?.let { return intArrayOf(it, index) }
            diffMap[target - int] = index
        }
        return intArrayOf()

    }
}
