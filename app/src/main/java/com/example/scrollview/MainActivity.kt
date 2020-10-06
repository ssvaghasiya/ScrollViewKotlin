package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dataList: MutableList<Data> = mutableListOf()
    lateinit var myadapter : GridDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        dataList = generateDummyList(10)
        dataList.add(Data(R.drawable.gallary,"Gallary"))
        dataList.add(Data(R.drawable.users,"Users"))
        dataList.add(Data(R.drawable.ads1,"Advertise"))
        dataList.add(Data(R.drawable.contact1,"Contact"))
        myadapter = GridDataAdapter(dataList)

        recycler_view.layoutManager = GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = myadapter
        recycler_view.isFocusable = false
        recycler_view.isNestedScrollingEnabled = false
        recycler_view.addItemDecoration(SpacesItemDecoration())
    }

    private fun generateDummyList(size: Int): MutableList<Data>{
        val list = ArrayList<Data>()

        for(i in 0 until size){
            val drawable = R.drawable.image_1
            val item = Data(drawable, "admin $i")
            list += item
        }
        return list
    }
}