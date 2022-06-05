package edu.uw.ee523.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ee523.roomdbsample.data.FriendDatabase

class ShowDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        // Set up the UI
        val myBtDeviceListAdapter = FriendDataListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.friendListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myBtDeviceListAdapter

        val db = FriendDatabase.getDatabase(applicationContext)
        val friendDao = db.friendDao()


        myBtDeviceListAdapter.submitList(friendDao.getAll())
    }
}