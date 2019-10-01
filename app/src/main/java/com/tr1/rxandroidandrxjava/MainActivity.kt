package com.tr1.rxandroidandrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        initLayout()
    }

    private fun initLayout()
    {
        sugar()
    }
    private fun sugar()
    {
        button.clicks().map {
            incrementCounter1()  }
            .throttleFirst(1000,TimeUnit.MILLISECONDS)
            .subscribe {
                incrementCounter2()
            }
    }

    private fun incrementCounter1(){
      var newVal1 = textView.text.toString().toInt()
        newVal1++
        textView.text = newVal1.toString()
    }

    private fun incrementCounter2(){
        var newVal1 = textView2.text.toString().toInt()
        newVal1++
        textView2.text = newVal1.toString()
    }
}
