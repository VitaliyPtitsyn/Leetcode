class Solution {
        fun lengthOfLongestSubstring(s: String): Int {

      if(s.isEmpty()) return 0
        var bestResult=1
        var inSearch=true
        val setOfUsedCharters= hashSetOf<Char>()
        var curentSerachStartPostin=0
        var charArray=s.toCharArray()
        while(inSearch){
            var currentResult=0
            setOfUsedCharters.clear()  
                     
            loop@ for( index in curentSerachStartPostin until charArray.size){
            
                if(setOfUsedCharters.add(charArray[index])){
                    currentResult++
                } else break@loop
            }

            curentSerachStartPostin++
            if(currentResult > bestResult) {
                bestResult = currentResult
            }
            if(curentSerachStartPostin==charArray.size)
                inSearch=false
        }
        return bestResult
    }
}