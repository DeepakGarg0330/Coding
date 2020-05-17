package com.example.codingassignment.activity

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingassignment.R
import com.example.codingassignment.adapters.CitySearchAdapter
import com.example.codingassignment.utils.StringUtil
import com.example.codingassignment.viewmodel.CitySearchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class CitySearchActivity : AppCompatActivity() {
    lateinit var adapter : CitySearchAdapter
    lateinit var dataViewModel : CitySearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataViewModel = ViewModelProviders.of(this).get(CitySearchViewModel::class.java)
        addObservers()
        search_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = CitySearchAdapter(this,null)
        search_recycler_view.adapter = adapter
        setListener()
    }

    fun addObservers(){
        dataViewModel.liveData.observe(this, Observer {
            adapter.updateList(it?.data?.addressList)
        })
        dataViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
        })
    }

    fun setListener(){
        et_query.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(dataViewModel.queryString.equals(s.toString())){
                    return
                }
                dataViewModel.queryString = s.toString()
                if(StringUtil.isNotBlank(dataViewModel.queryString) || StringUtil.isNotBlank(dataViewModel.cityName)){
                    dataViewModel.getAddress(dataViewModel.queryString,dataViewModel.cityName)
                }else{
                    adapter.updateList(null)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        et_city.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(dataViewModel.cityName.equals(s.toString())){
                    return
                }
                dataViewModel.cityName = s.toString()
                if(StringUtil.isNotBlank(dataViewModel.cityName) || StringUtil.isNotBlank(dataViewModel.queryString)){
                    dataViewModel.getAddress(dataViewModel.queryString,dataViewModel.cityName)
                }else{
                    adapter.updateList(null)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }



}
