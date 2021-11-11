package com.mnyan.submissionbfaa_II.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kylix.submissionbfaa_II.model.GithubUser
import com.kylix.submissionbfaa_II.networking.UserRetrofit
import com.kylix.submissionbfaa_II.utils.Resource

class HomeViewModel : ViewModel() {

    private val username: MutableLiveData<String> = MutableLiveData()

    val searchResult: LiveData<Resource<List<GithubUser>>> = Transformations
        .switchMap(username) {
            UserRetrofit.searchUsers(it)
        }

    fun setSearch(query: String) {
        if (username.value == query) {
            return
        }
        username.value = query
    }
}