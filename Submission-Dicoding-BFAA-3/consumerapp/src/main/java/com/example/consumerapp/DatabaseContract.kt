package com.example.consumerapp

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {
    const val AUTHORITY = "com.mnyn.githubapp"
    const val SCHEME = "content"

    internal class FavoriteUserColumns : BaseColumns{
        companion object {
            const val TABLE_NAME="favorite_user"
            const val ID="id"
            const val USERNAME="username"
            const val AVATAR_URL="avatar_url"


            val CONTENT_URI = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}