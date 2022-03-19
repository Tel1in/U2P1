package mx.tecnm.tepic.u2p1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copos(l:Lienzo) {
    var l = l
    var x = 0f
    var y = 0f


    init {
        x= rand(2000)
        y= rand(2000)*-1

    }

    private fun rand(hasta:Int): Float {
        return  Random.nextInt(hasta).toFloat()
    }

    fun moverCopos(){
        y +=5
        if(y>1500) y= -100f
    }

    fun pintarCopos(c : Canvas){
        val p = Paint()
        p.color = Color.WHITE
        c.drawCircle(x,y,5f,p)
    }
}