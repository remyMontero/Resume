package com.muenchen.resume.Models

import com.muenchen.resume.R
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//Sets Singleton
object DataManager {
    val userInfo = UserInformation("Remy Muenchen", "email@email.com", "123-123-1234");
    val jobs = ArrayList<Job>();
    val companies = HashMap<Int, Company>();
    val projects = ArrayList<Project>();
    val keyWords= ArrayList<String>();

    init {
        initializeProjects();
        initializeCompanies();
        initializeJobs();
        initializeKeyWords();
    }

    private fun initializeJobs(){
        var job = Job(100, "Mobile Developer", "Write mobile apps", "2017-08-08", null, projects =  projects, company = companies.get(3));
        jobs.add(job);

        job = Job(200, "Software Development & Implementation Consultant", "Maintain Web/Mobile apps", "2015-01-01" , "2017-08-07", projects, companies.get(2));
        jobs.add(job);

        job = Job(300, "Software Engineer", "Everything", "2013-05-10", "2014-12-31", projects, companies.get(1))
        jobs.add(job);
    }

    private fun initializeCompanies(){
        var company = Company(1, "GroundWork group", "", R.drawable.gwg);
        companies.set(1, company);
        company = Company(2, "Sogeti", "", R.drawable.sogeti);
        companies.set(2, company);
        company = Company(3, "Pure Romance", "", R.drawable.pureromance);
        companies.set(3, company);
    }



    private fun initializeProjects(){
        var project = Project(1,"Xamarin", "Android Mobile", null, 1.0);
        projects.add(project);
        project = Project(2,"ASP Web Dev", "Web Dev", null, 1.0);
        projects.add(project);
        project = Project(3,".Net Core", "Web Services", null, 1.0);
        projects.add(project);
    }


    private fun initializeKeyWords(){
        keyWords.add("Kotlin");
        keyWords.add("Xamarin");
        keyWords.add("Xamarin Forms");
        keyWords.add("XCode");
        keyWords.add("Angular");
        keyWords.add(".Net Core");
        keyWords.add("Docker");
        keyWords.add("React");
        keyWords.add("React Native");
        keyWords.add("CMS");
        keyWords.add("PHP");
        keyWords.add("MVVMCross");
        keyWords.add("Android");
        keyWords.add("iOS");

        keyWords.add("Github");
        keyWords.add("Agile");
        keyWords.add("DevOps");
        keyWords.add("CI/CD");
        keyWords.add("UI/UX");
        keyWords.add("SQL");
        keyWords.add("SQLite");
        keyWords.add("Java");
        keyWords.add("JS");
        keyWords.add("BootStrap");
    }
}