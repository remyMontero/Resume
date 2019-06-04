package com.muenchen.resume.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.flexbox.AlignItems
import com.muenchen.resume.CURRENT_JOB_LABEL
import com.muenchen.resume.Models.Job
import com.muenchen.resume.Models.Project
import com.muenchen.resume.R

class DoubleLineRecylerAdapter(val items:ArrayList<Any>): RecyclerView.Adapter<DoubleLineRecylerAdapter.ViewHolder>() {
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
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
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoubleLineRecylerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.double_line_item, parent, false)
        return ViewHolder(v);
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.textTitle)
        val txtSubtitle= itemView.findViewById<TextView>(R.id.textSubtitle)
    }
}