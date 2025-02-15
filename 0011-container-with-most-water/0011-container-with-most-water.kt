class Solution {
    fun maxArea(heightArray: IntArray): Int {
        var maxResult=0
        var start=0
        var end=heightArray.size-1
        while (start<end ){
            val startHeight=heightArray[start]
            val endHeight=heightArray[end]
            var valuem= (end - start) * min( startHeight, endHeight)
            if(valuem>=maxResult)
                maxResult=valuem
            if(startHeight> endHeight){
                end--
            } else {
                start++
            }
        }
        return maxResult
    }
}