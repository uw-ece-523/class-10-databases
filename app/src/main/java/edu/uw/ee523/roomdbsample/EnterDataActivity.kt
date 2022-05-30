package edu.uw.ee523.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EnterDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_data)
    }

    fun addNewEntry(view: View) {}
}