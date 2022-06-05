package edu.uw.ee523.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.annotation.WorkerThread
import androidx.room.Room
import edu.uw.ee523.roomdbsample.data.FriendDataEntity
import edu.uw.ee523.roomdbsample.data.FriendDatabase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class EnterDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_data)
    }

     fun addEntry(friend: FriendDataEntity) {
        val db = FriendDatabase.getDatabase(applicationContext)
        val friendDao = db.friendDao()
        friendDao.insert(friend)
    }

    fun addNewEntry(view: View) {
        val firstNameET = findViewById<EditText>(R.id.first_name_editText)
        val lastNameET = findViewById<EditText>(R.id.last_name_editText)
        val firstName = firstNameET.text.toString()
        val lastName = lastNameET.text.toString()

        val friend = FriendDataEntity(firstName=firstName, lastName=lastName)
        addEntry(friend)

        firstNameET.text.clear()
        lastNameET.text.clear()
    }
}