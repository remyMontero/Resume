package com.muenchen.resume.Models

import java.util.*

data class UserInformation(val name:String, val email:String, val phone:String)

data class Job (val jobId:Int,
                val jobTitle:String,
                val jobSummary: String,
                var jobFrom:String,
                var jobTo:String?,
                var projects: ArrayList<Project>,
                val company: Company?){
    override fun toString(): String {
        return jobTitle;
    }
}


data class Project(val projectId: Int,
                   val projectTitle: String,
                   val projectSummary: String,
                   val projectType: TechnologyType? = TechnologyType(0, "Language"),
                   var projectRanking: Double = 0.0){
    override fun toString(): String {
        return projectTitle;
    }

}

data class Company(val companyId:Int,
                   val companyName:String,
                   val companyDescription: String,
                   val companyLogoResource: Int);

data class TechnologyType (val id:Int, val name: String)
