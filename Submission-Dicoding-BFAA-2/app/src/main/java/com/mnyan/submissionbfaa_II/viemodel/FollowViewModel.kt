package com.mnyan.submissionbfaa_II.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kylix.submissionbfaa_II.model.GithubUser
import com.kylix.submissionbfaa_II.networking.UserRetrofit
import com.kylix.submissionbfaa_II.utils.Resource
import com.kylix.submissionbfaa_II.utils.TypeView

class FollowViewModel : ViewModel() {
    private val username: MutableLiveData<String> = MutableLiveData()

    private lateinit var type: TypeView

    val dataFollow: LiveData<Resource<List<GithubUser>>> = Transformations
        .switchMap(username) {
            when (type) {
                TypeView.FOLLOWER -> {
                    UserRetrofit.getFollowers(it)
                }
                TypeView.FOLLOWING -> {
                    UserRetrofit.getFollowing(it)
                }
            }
        }

    fun setFollow(user: String, typeView: TypeView) {
        if (username.value == user) {
            return
        }
        username.value = user
        type = typeView
    }
}