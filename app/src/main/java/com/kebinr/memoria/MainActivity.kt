package com.kebinr.memoria

import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val images: MutableList<Int> = mutableListOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6)
        val buttons: Array<ImageButton> = arrayOf(imageButton,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6,imageButton7,imageButton8,imageButton9,imageButton10,imageButton11,imageButton12)
        var clicked =0
        var turnover =false
        var lastclicked = -1
        images.shuffle()
        for (i:Int in 0..11){
            buttons[i].setTag("CardBack")
            buttons[i].setOnClickListener {
                if (buttons[i].getTag().toString()=="CardBack" && !turnover){
                    buttons[i].setImageResource(images[i])
                    buttons[i].setTag(images[i])
                    if (clicked==0){
                        lastclicked=i
                    }
                    clicked++
                }
                //gano puntos
                if(clicked ==2){
                    turnover = true
                    if(buttons[i].getTag().toString()==buttons[lastclicked].getTag().toString()){
                        buttons[i].isClickable = false
                        buttons[lastclicked].isClickable = false
                        val int =Integer.parseInt(textView.text.toString()) +  100
                        textView.text = int.toString()
                        turnover=false
                        clicked=0
                        if(Integer.parseInt(textView.text.toString()) ==600){
                            textView3.text ="WIN"
                        }
                    }else{
                        //Temporizador
                        val handler = Handler()
                        handler.postDelayed({
                            buttons[i].setImageResource(R.drawable.question__1_)
                            buttons[lastclicked].setImageResource(R.drawable.question__1_)
                            buttons[i].setTag("CardBack")
                            buttons[lastclicked].setTag("CardBack")
                            clicked=0
                            turnover=false
                        }, 1000)
                    }
                }
            }
        }
        imageButton17.setOnClickListener {
            images.shuffle()
            clicked=0
            turnover=false
            textView.text = "0"
            for (i:Int in 0..11){
                buttons[i].setImageResource(R.drawable.question__1_)
                buttons[i].setTag("CardBack")
                buttons[i].isClickable=true
                textView3.text=""
            }
        }
    }
}
