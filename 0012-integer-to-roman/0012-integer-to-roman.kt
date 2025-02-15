class Solution {
    val romanNumberMap= hashMapOf<Int,String>(
        Pair(1,"I",)    ,
        Pair(5,"V")	,
        Pair(10,"X")	,
        Pair(50,"L")	,
        Pair(100,"C")	,
        Pair(500,"D")	,
        Pair(1000,"M")	,
    )
    fun intToRoman(num: Int): String {
        val builder= StringBuilder()
        var reminder=num
        var numberSplitter=1000
        System.out.println("num:  number $num  ")
        while (reminder>0 && numberSplitter>0){
           val number=reminder / numberSplitter
            builder.append(number.toRoman(numberSplitter*10))
            reminder %= numberSplitter
            numberSplitter /= 10
        }
     return builder.toString()
    }
    fun Int.toRoman(order:Int):String{
        if(this==0) return ""
        val builder= StringBuilder()
        val reminder= this%5
        var endSymbol :String
        var startSymbol :String =romanNumberMap[order/10] ?:""
        if(this>5){
            endSymbol= romanNumberMap[order] ?: ""
        } else {
            endSymbol= romanNumberMap[order/2] ?: ""
        }
        System.out.println("number $this  order $order endSymbol $endSymbol startSymbol $startSymbol  reminder $reminder ")
        when(reminder){
            in 1..3 -> {
                if(this> 5)  builder.append(romanNumberMap[order/2])
                for(i in 1.. reminder)
                   builder.append(startSymbol)
            }
            4 -> {
                builder.append(startSymbol)
                builder.append(endSymbol)
            }
            0  -> {builder.append(endSymbol)}
        }
        System.out.println("ADDER ${builder.toString()} ")
        return builder.toString()
    }
}