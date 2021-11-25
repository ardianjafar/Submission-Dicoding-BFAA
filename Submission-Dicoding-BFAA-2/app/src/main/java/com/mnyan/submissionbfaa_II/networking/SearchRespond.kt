package com.mnyan.submissionbfaa_II.networking

import android.os.Parcelable
import com.kylix.submissionbfaa_II.model.GithubUser
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRespond(
    val total_count : String,
    val incomplete_results: Boolean? = null,
    val items : List<GithubUser>
): Parcelable