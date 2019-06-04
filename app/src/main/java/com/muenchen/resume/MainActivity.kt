package com.muenchen.resume

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.muenchen.resume.Activities.JobDescriptionActivity
import com.muenchen.resume.Adapters.DoubleLineAdapter
import com.muenchen.resume.Models.DataManager
import com.muenchen.resume.Models.Job

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        populateDefaultData();
    }

    private fun populateDefaultData(){
        textName.text = DataManager.userInfo.name;
        textEmail.text = DataManager.userInfo.email;
        textPhone.text = DataManager.userInfo.phone;

        listJobItems.adapter = DoubleLineAdapter(this, DataManager.jobs as ArrayList<Any>);

        listJobItems.setOnItemClickListener {parent,  view, position, id ->
            val activityIntent = Intent(this, JobDescriptionActivity::class.java);
            val job = parent.getItemAtPosition(position) as Job;
            activityIntent.putExtra(CURRENT_JOB_ID, job?.jobId);
            startActivity(activityIntent);
        };
    }

}
