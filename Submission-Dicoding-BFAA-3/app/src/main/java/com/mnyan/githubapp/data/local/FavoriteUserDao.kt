package com.mnyan.githubapp.data.local

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import com.mnyan.githubapp.data.model.DetailUserResponse
import retrofit2.http.Query

@Dao
interface FavoriteUserDao {
    @Insert
    suspend fun addToFavorite(favoriteUser: FavoriteUser)

    @Query("SELECT * FROM favorite_user")
    fun getFavoriteUser() : LiveData<List<FavoriteUser>>

    @Query("SELECT count(*) FROM favorite_user WHERE favorite_user.id = :id")
    suspend fun checkUser(id : Int) :Int

    @Query("DELETE FROM favorite_user WHERE favorite_user.id = :id")
    suspend fun removeFromFavorite(id : Int) : Int

    @Query("SELECT * FROM favorite_user")
    fun findAll() : Cursor
}