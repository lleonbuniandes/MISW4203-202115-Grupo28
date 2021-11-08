package edu.uniandes.vinilosapp.views

import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.R

class MyToolbar{
    fun show (activities: AppCompatActivity, title:String, upButton: Boolean){
        activities.setSupportActionBar(activities.findViewById(R.id.my_toolbar))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }

}