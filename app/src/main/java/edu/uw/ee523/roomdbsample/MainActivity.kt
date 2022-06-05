package edu.uw.ee523.roomdbsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.uw.ee523.roomdbsample.data.FriendDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDbEnter(view: View) {
        startActivity(Intent(this, EnterDataActivity::class.java))
    }

    fun showDbRead(view: View) {
        startActivity(Intent(this, ShowDataActivity::class.java))
    }
}