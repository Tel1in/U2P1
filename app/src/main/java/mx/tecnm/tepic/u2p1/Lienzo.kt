package mx.tecnm.tepic.u2p1

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity): View(este) {
    val este=este
    val copos = Array<Copos>(50,{ Copos(this) })
    var luna= BitmapFactory.decodeResource(este.resources,R.drawable.luna)

    val corrutina = GlobalScope.launch {
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            delay(10L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        c.drawColor(Color.BLACK)
        val p = Paint()
        c.drawBitmap(luna,100f,50f,p)
        //CAMINO CON CARRETERA

        p.color=(Color.WHITE)
        c.drawRect(0f,2100f,1500f,700f,p)

        p.color=Color.GRAY
        c.drawRect(0f,1200f,1500f,1000f,p)

        p.color=Color.rgb(74,68,12)
        c.drawRect(20f,1000f,100f,900f,p)
        p.color=Color.GREEN
        c.drawCircle(68f,870f,80f,p)

        p.color=Color.rgb(74,68,12)
        c.drawRect(300f,1000f,380f,900f,p)
        p.color=Color.GREEN
        c.drawCircle(350f,870f,80f,p)

        p.color=Color.rgb(74,68,12)
        c.drawRect(600f,1000f,680f,900f,p)
        p.color=Color.GREEN
        c.drawCircle(650f,870f,80f,p)

        p.color=Color.BLACK
        c.drawRect(0f,1100f,1500f,1095f,p)

        for(cop in copos){
            cop.moverCopos()
            cop.pintarCopos(c)
        }





    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
       event.x
       event.y
        when(event.action){
           MotionEvent.ACTION_DOWN->{

           }
           MotionEvent.ACTION_MOVE->{

           }
           MotionEvent.ACTION_UP->{
                if(event.y<500){
                    (0..copos.size-1).forEach {
                        if (copos[it].y<-0){
                            copos[it].y --
                        }
                        if (copos[it].y>0){
                            copos[it].y ++
                        }
                    }
                }

           }
       }
        invalidate()
        return true
    }
}