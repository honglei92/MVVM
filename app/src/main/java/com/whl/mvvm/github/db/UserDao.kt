package com.whl.mvvm.github.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.whl.mvvm.github.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(user: User)

    @Delete
    fun deleteStudent(user: User)

    @Query("SELECT * FROM user WHERE login = :login")
    fun getUserByName(login: String): LiveData<User>
}