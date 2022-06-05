package edu.uw.ee523.roomdbsample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FriendDataEntity::class], version = 3)
abstract class FriendDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDataDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FriendDatabase? = null

        fun getDatabase(context: Context): FriendDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FriendDatabase::class.java,
                    "my_friend_database"
                ).allowMainThreadQueries()  // NOT GOOD!! Just for demo.
                    .fallbackToDestructiveMigration() // For when our database changes
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

