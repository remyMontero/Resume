package com.muenchen.resume.Adapters

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.muenchen.resume.CURRENT_JOB_LABEL
import com.muenchen.resume.Models.Job
import com.muenchen.resume.Models.Project
import com.muenchen.resume.R

class DoubleLineAdapter(private val activity: Context?, private val items:ArrayList<Any>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.double_line_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item =  when(items[position]){
            is Project -> {
                viewHolder?.txtTitle?.text = (items[position] as Project).projectTitle;
                viewHolder?.txtSubtitle?.text = (items[position] as Project).projectSummary;
            };
            else -> {
                val job = (items[position] as Job);
                viewHolder?.txtTitle?.text = job.jobTitle;
                viewHolder?.txtSubtitle?.text = """${job.jobSummary} (${job.jobFrom} - ${job.jobTo ?: CURRENT_JOB_LABEL})""";
            };
        }

        return view as View;
    }

    override fun getItem(position: Int): Any {
        return items[position];
    }

    override fun getItemId(i: Int): Long {
        return i.toLong();
    }

    override fun getCount(): Int {
        return items.size;
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.textTitle)
        val txtSubtitle= itemView.findViewById<TextView>(R.id.textSubtitle)
    }
}