package com.whl.mvvm.github.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.whl.mvvm.github.model.User

@Database(entities = [User::class], version = 2)
abstract class UserDatabase : RoomDatabase() {
    companion object {
        val DATABASE_NAME: String = "user_db"
        var databaseInstance: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return databaseInstance
        }
    }

    abstract fun userDao(): UserDao
}
