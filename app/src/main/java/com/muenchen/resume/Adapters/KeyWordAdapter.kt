package com.muenchen.resume.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.muenchen.resume.R
import kotlinx.android.synthetic.main.content_job_description.*

class KeyWordAdapter(val keyWords:ArrayList<String>): RecyclerView.Adapter<KeyWordAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: KeyWordAdapter.ViewHolder, position: Int) {
       holder?.txtKeyWord?.text = keyWords[position];
    }

    override fun getItemCount(): Int {
        return keyWords.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyWordAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.horizontal_list_item, parent, false)
        return ViewHolder(v);
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtKeyWord = itemView.findViewById<TextView>(R.id.textHorizontalItem)
    }
}