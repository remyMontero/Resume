package com.muenchen.resume.Activities

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.muenchen.resume.*
import com.muenchen.resume.Adapters.DoubleLineAdapter
import com.muenchen.resume.Adapters.KeyWordAdapter
import com.muenchen.resume.Models.DataManager
import com.muenchen.resume.Models.Project

import kotlinx.android.synthetic.main.activity_job_description.*
import kotlinx.android.synthetic.main.content_job_description.*

class JobDescriptionActivity : AppCompatActivity() {
    private var jobId = JOB_ID_NOT_SET;
    private var isLastIndex = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_description)
        setSupportActionBar(toolbar)

        jobId =  savedInstanceState?.getInt(CURRENT_JOB_ID, JOB_ID_NOT_SET) ?:
                intent.getIntExtra(CURRENT_JOB_ID, JOB_ID_NOT_SET);

        loadData();
    }

    //inflates the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.action_next -> {
                moveNext();
                return true;
            };
            else ->super.onOptionsItemSelected(item);
        }
    }

    //check last index to change the icon for the menu
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(DataManager.jobs.last().jobId == jobId){
            val menuItem = menu?.findItem(R.id.action_next);
            if(menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24dp);
                menuItem.isEnabled = false;
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(CURRENT_JOB_ID, jobId);
    }

    private fun moveNext(){
        var currentIndex = DataManager.jobs.indexOf(DataManager.jobs.find { n->n.jobId == jobId });
        jobId = DataManager.jobs.get(++currentIndex)?.jobId;

        loadData();
        this.invalidateOptionsMenu();//Forces menu refresh
    }

    private fun loadData(){
        val job = DataManager.jobs.find { n -> n.jobId == jobId }

        imageView.setImageResource(job?.company?.companyLogoResource as Int);

        toolbar.title = job?.jobTitle;
        textJobTitle.text = job?.jobTitle;
        textJobCompany.text = job?.company?.companyName;
        textJobTime.text = """${job?.jobFrom}  ${job?.jobTo ?: CURRENT_JOB_LABEL}""";

        listProjects.adapter = DoubleLineAdapter(this, job?.projects as ArrayList<Any>);

        listProjects.setOnItemClickListener { parent, view, position, id ->
            DisplayAlert();
        }

        val flexboxLayoutManager = FlexboxLayoutManager(this).apply(){
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        listKeyWords.apply {
            layoutManager = flexboxLayoutManager
            adapter = KeyWordAdapter(DataManager.keyWords)
            adapter = KeyWordAdapter(DataManager.keyWords)
        };
    }

    private fun DisplayAlert(){
        val job = DataManager.jobs.find { n -> n.jobId == jobId }

        val builder = AlertDialog.Builder(this)
        builder.setTitle(job?.jobTitle)
        builder.setMessage(job?.jobSummary)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                job?.jobTitle + " closed", Toast.LENGTH_SHORT).show();
        }

        builder.show()
    }

}
