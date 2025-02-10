class Solution {
    fun longestPalindrome(s: String): String {
        var windowsDedicaction=s.length
        while (windowsDedicaction>0){
            var offset=0
            while (offset+windowsDedicaction<=s.length){
                val searchString=s.substring(offset,windowsDedicaction+offset)
                if(searchString.isPallindrome()) return searchString
                offset++
            }
            windowsDedicaction--
        }
        return s.first().toString()
    }
    fun String.isPallindrome() : Boolean {
      val endSearch= (this.length)/2
      for( i in 0..endSearch){
          if(get(i) != get(this.length-i-1))
              return false
      }
        return true
    }
}