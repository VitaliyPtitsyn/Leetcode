class Solution {
    class ParsedNumber{
        private val limits_up=Int.MAX_VALUE.toLong()
        private val limits_Bottom :Long=limits_up +1L
        private var isWriteNumberStarted=false
        private var resultNumber=0L
            set(value) {
                field=value
                isWriteNumberStarted=true
            }
         var isPositive=true
            set(value) {
                field=value
                isWriteNumberStarted = true
            }
        fun isWriteAvailable() = !isWriteNumberStarted
        fun incrementNumber(char: Char){
            var incremnt = resultNumber
            incremnt *=10
            incremnt += Character.getNumericValue(char);
            resultNumber = when {
                isPositive && incremnt > limits_up -> limits_up
                isPositive.not() && incremnt > limits_Bottom -> limits_Bottom
                else -> incremnt
            }
            System.out.println("incrementNumber: $char resultNumber $resultNumber  incremnt$incremnt")
        }
        fun provide(): Int =
            if(isPositive){
                if(resultNumber  > Int.MAX_VALUE) Int.MAX_VALUE else resultNumber.toInt()
            } else  if(resultNumber *-1 < Int.MIN_VALUE) Int.MIN_VALUE else resultNumber.toInt() *-1
    }
    fun myAtoi(s: String): Int {
        val targetNumber=ParsedNumber()
       run breaking@ {
            s.subSequence(0, s.length).forEach { char ->
                System.out.println(char.code)
                when (char.code) {
                    ' '.code -> if (targetNumber.isWriteAvailable().not()) return@breaking
                    '-'.code -> if (targetNumber.isWriteAvailable().not()) return@breaking else targetNumber.isPositive =
                        false
                    '+'.code -> if (targetNumber.isWriteAvailable().not()) return@breaking else targetNumber.isPositive =
                        true
                    in '0'.code..'9'.code -> targetNumber.incrementNumber(char)
                    else -> return@breaking
                }
            }
        }
        return targetNumber.provide()
    }
}