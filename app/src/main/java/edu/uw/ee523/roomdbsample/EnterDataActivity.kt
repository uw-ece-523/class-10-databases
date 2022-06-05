package edu.uw.ee523.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import edu.uw.ee523.roomdbsample.data.FriendDataEntity
import edu.uw.ee523.roomdbsample.data.FriendDatabase

class EnterDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_data)
    }

    fun addEntry(friend: FriendDataEntity) {
        // Get database
        val db = FriendDatabase.getDatabase(applicationContext)

        // Get the dao for the db
        val dao = db.myFriendDao()

        // Insert our friend
        dao.insert(friend)
    }

    fun addNewEntry(view: View) {
        // Get edit text widgets
        val firstNameET = findViewById<EditText>(R.id.first_name_editText)
        val lastNameET = findViewById<EditText>(R.id.last_name_editText)
        val firstName = firstNameET.text.toString()
        val lastName = lastNameET.text.toString()

        // Create friend from input
        val friend = FriendDataEntity(firstName = firstName, lastName = lastName)

        // add Friend entry
        addEntry(friend)

        // Clear edit text widgets
        firstNameET.text.clear()
        lastNameET.text.clear()
    }
}