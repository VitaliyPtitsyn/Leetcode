class Solution {
    val romanNumberMap= hashMapOf<Int,String>(
        Pair(1,"I",),
        Pair(5,"V"),
        Pair(10,"X"),
        Pair(50,"L"),
        Pair(100,"C"),
        Pair(500,"D"),
        Pair(1000,"M"),
    )
    fun intToRoman(num: Int): String {
        val builder= StringBuilder()
        var reminder=num
        var numberSplitter=1000
        while (reminder>0){
           val number=reminder / numberSplitter
            number.toRoman(builder,numberSplitter*10)
            reminder %= numberSplitter
            numberSplitter /= 10
        }
     return builder.toString()
    }
    fun Int.toRoman(builder:StringBuilder,order:Int){
        if(this==0) return
        val reminder= this%5
        val startSymbol :String =romanNumberMap[order/10] ?:""
        val endSymbol :String =  romanNumberMap[if(this>5) order else  order/2] ?: ""
        when(reminder){
            in 1..3 -> {
                if(this> 5)  builder.append(romanNumberMap[order/2])
                for(i in 1.. reminder) builder.append(startSymbol)
            }
            4 -> {
                builder.append(startSymbol)
                builder.append(endSymbol)
            }
            0  -> {builder.append(endSymbol)}
        }
    }
}