package com.whl.mvvm.github.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class User {
    @PrimaryKey
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Int = 0

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String = ""

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    var avatar: String = "";

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    var followers: Int = 0

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    var following: Int = 0

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    var blog: String = ""

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    var company: String = ""

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    var bio: String = ""

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    var location: String = ""

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("html_url")
    var htmlUrl: String = ""

    fun User(
        id: Int,
        name: String,
        avatar: String,
        followers: Int,
        following: Int,
        blog: String,
        company: String,
        bio: String,
        location: String,
        htmlUrl: String
    ) {
        this.id = id
        this.name = name
        this.avatar = avatar
        this.followers = followers
        this.following = following
        this.blog = blog
        this.company = company
        this.bio = bio
        this.location = location
        this.htmlUrl = htmlUrl
    }
}