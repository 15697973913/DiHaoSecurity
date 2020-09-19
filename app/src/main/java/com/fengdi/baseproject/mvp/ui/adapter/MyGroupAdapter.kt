package com.fengdi.baseproject.mvp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.fengdi.baseproject.R
import com.fengdi.baseproject.app.entity.GroupBean

class MyGroupAdapter(var data: List<GroupBean>,var context:Context) : BaseAdapter() {


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_unlock_message, parent, false)
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}