package edu.uw.ee523.roomdbsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friends")
data class FriendDataEntity (
    val firstName: String,
    val lastName: String
    ) {

    @PrimaryKey(autoGenerate = true)
    public var id: Int? = null
    var age: Int = 0
}

