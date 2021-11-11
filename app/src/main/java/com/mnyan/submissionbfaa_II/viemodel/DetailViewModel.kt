package com.mnyan.submissionbfaa_II.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kylix.submissionbfaa_II.model.GithubUser
import com.kylix.submissionbfaa_II.networking.UserRetrofit
import com.kylix.submissionbfaa_II.utils.Resource

class DetailViewModel : ViewModel() {

    private val username: MutableLiveData<String> = MutableLiveData()

    val dataDetail: LiveData<Resource<GithubUser>> = Transformations
        .switchMap(username) {
            UserRetrofit.getDetailUser(it)
        }

    fun setDetail(userid: String) {
        if (username.value == userid) {
            return
        }
        username.value = userid
    }
}