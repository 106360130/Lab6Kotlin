package com.example.lab6kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cubee_list.view.*




class MainActivity : AppCompatActivity() {

    data class Data(val photo: Int,  val name: String)



    class MyAdapter constructor(
        private val layout: Int, private val data: ArrayList<Data>) : BaseAdapter() {

        override fun getCount() = data.size

        override fun getItem(position : Int) = data[position]

        override fun getItemId(position : Int) = 0L

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View{
            val view = View.inflate(parent?.context, layout, null)

            view.imageView.setImageResource(data[position].photo)

            view.name.text = data[position].name

            return view

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //車子圖和字
        val transNameArray = arrayOf("腳踏車","機車","汽車","巴士")
        val transPhotoIdArray = intArrayOf(R.drawable. trans1,R.drawable.trans2,R.drawable. trans3,R.drawable. trans4)

        val transData = ArrayList<Data>()
        for (i in 0 until transPhotoIdArray.size)
        {
            transData.add(Data(transPhotoIdArray[i],transNameArray[i]))  //前面是代碼，後面是名字
        }

        spinner.adapter = MyAdapter(R.layout.trans_list, transData)

        //cubeew圖和字
        val cubeeNameArray = arrayOf("哭哭","發抖","再見","生氣","昏倒","竊笑","很棒","你好","驚嚇","大笑")
        val cubeePhotoIdArray = intArrayOf(R.drawable.cubee1,R.drawable.cubee2,
            R.drawable.cubee3,R.drawable.cubee4,R.drawable.cubee5,R.drawable.cubee6,
            R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10)

        val cubeeData = ArrayList<Data>()
        for(i in 0 until cubeePhotoIdArray.size)  //for迴圈，從0到陣列的大小
        {
            cubeeData.add(Data(cubeePhotoIdArray[i],cubeeNameArray[i]))
        }

        gridView.numColumns = 3  //只顯示三個col
        gridView.adapter = MyAdapter(R.layout.cubee_list, cubeeData)

        //內建

        val messageArray = arrayOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6")
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messageArray)
    }
}
