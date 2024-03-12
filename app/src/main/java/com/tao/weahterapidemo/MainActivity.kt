package com.tao.weahterapidemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tao.weahterapidemo.Constant.API_KEY
import com.tao.weahterapidemo.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendGetTypeRequest()

    }

    private fun sendGetTypeRequest(latitude:String, longitude:String){

        val requestQueue = Volley.newRequestQueue(this)
        val queryParam = "lat=$latitude&lon=$longitude$appid=$API_KEY"
        val stringRequest = StringRequest(
            Request.Method.GET
            requestUrl,
            {
                val token = object:TypeToken<WeatherResponse>(){}
                val response = Gson().fromJson(it,token)
                Log.i("tag",response.name)
            },{
                Log.i("tag",it.toString())
            }
        )
        requestQueue.add(stringRequest)
    }
}