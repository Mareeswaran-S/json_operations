package com.example.jsonarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var txtview : TextView
    var strJson = ("{ \"Employee\" :[{\"ID\":\"01\",\"Name\":\"Marees\",\"Salary\":\"50000\"},"
            + "{\"ID\":\"02\",\"Name\":\"Venkatesh\",\"Salary\":\"60000\"}] }")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtview=findViewById(R.id.txtview)
        val data = StringBuilder()
        val jsonObject=JSONObject(strJson)
        val jsonArray = jsonObject.optJSONArray("Employee")
        for (i in 0 until jsonArray.length())
        {
            val jsonObject = jsonArray.getJSONObject(i)
            val id = jsonObject.optString("ID").toInt()
            val name = jsonObject.optString("Name")
            val salary = jsonObject.optString("Salary").toFloat()
            data.append("Employee").append(i).append(": \n ID= ").append(id).append("\n" + "Name= ").append(name).append("\n Salary= ").append(salary).append("\n\n")
        }
        txtview.text=data.toString()
    }
}