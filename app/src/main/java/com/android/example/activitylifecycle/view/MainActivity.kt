package com.android.example.activitylifecycle.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.android.example.activitylifecycle.R
import com.android.example.activitylifecycle.models.QuestionModel

class MainActivity : AppCompatActivity() {

    private lateinit var myModel: QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //myModel= ViewModelProvider(this).get(QuestionModel::class.java)//get only 1 instance
        myModel=QuestionModel.getInstance()//sharing

        val btn: Button = findViewById(R.id.btnNext)

        btn.setOnClickListener(){
            var intent: Intent = Intent(this, secondActivity::class.java)

            myModel.name = findViewById<TextView>(R.id.tfName).text.toString()

            startActivity(intent)
        }
    }
}