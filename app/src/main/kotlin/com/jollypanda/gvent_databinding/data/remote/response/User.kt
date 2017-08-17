package com.jollypanda.gvent_databinding.data.remote.response

import com.google.gson.annotations.SerializedName

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
data class User(@SerializedName("age") val age: Int? = null,
                @SerializedName("avatar") val photoUrl: String? = null,
                @SerializedName("id") val id: Int? = null,
                @SerializedName("lastSeen") val lastSeenTime: String? = null,
                @SerializedName("name") val name: String? = null,
                @SerializedName("similarity") val similarity: Int? = null,
                @SerializedName("status") val status: String? = null,
                @SerializedName("unreadMessages") val unreadMessages: Int? = null)