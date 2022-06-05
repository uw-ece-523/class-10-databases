package edu.uw.ee523.roomdbsample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDataDao {

    @Insert
    fun insert(friend: FriendDataEntity)

    @Query("SELECT * from friends")
    fun getAll(): List<FriendDataEntity>

}