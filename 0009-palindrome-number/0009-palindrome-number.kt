class Solution {
    fun isPalindrome(x: Int): Boolean {
         var normalNumber = x
        var reverseNumber = 0
        
        if(x < 0) return false

        while(normalNumber > 0) {
            var rest = normalNumber % 10 
            reverseNumber = (reverseNumber * 10) + rest
            normalNumber = normalNumber / 10
        }

        return reverseNumber == x
    }
}