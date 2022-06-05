package edu.uw.ee523.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uw.ee523.roomdbsample.data.FriendDataEntity
import edu.uw.ee523.roomdbsample.data.FriendDatabase

class ShowDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        // UI Stuff
        val friendListAdapter = FriendDataListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.friend_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = friendListAdapter

        // Get friends from db
        val db = FriendDatabase.getDatabase(applicationContext)
        val dao = db.myFriendDao()

        val friends = dao.getAll()

        // Show friends in list
        friendListAdapter.submitList(friends)

    }
}