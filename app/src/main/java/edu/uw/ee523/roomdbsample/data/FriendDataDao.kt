package edu.uw.ee523.roomdbsample.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FriendDataDao {

    @Insert
    fun insert(friend: FriendDataEntity)

    @Insert
    fun insertAll(vararg users: FriendDataEntity)

    @Delete
    fun delete(friend: FriendDataEntity)

    @Query("SELECT * FROM friends")
    fun getAll(): List<FriendDataEntity>
}
