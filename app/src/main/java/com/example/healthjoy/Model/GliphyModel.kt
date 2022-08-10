package com.example.healthjoy.Model

import com.google.gson.annotations.SerializedName

data class GliphyModel(@SerializedName("id") val id: String = "") {
    @SerializedName("type")
    val type: String = ""
    @SerializedName("url")
    val url: String = ""
    @SerializedName("slug")
    val slug: String = ""
    @SerializedName("embed_url")
    val embedUrl: String = ""
    @SerializedName("username")
    val username: String = ""
    @SerializedName("source")
    val source: String = ""
    @SerializedName("title")
    val title: String = ""
    @SerializedName("rating")
    val rating: String = ""
    @SerializedName("images")
    val images: Images = Images()
    @SerializedName("user")
    val user: User = User()

    data class Images(@SerializedName("original") val original: Original = Original())
    {
        data class Original(
            @SerializedName("url")
            val url: String = "",
            @SerializedName("mp4")
            val mp4: String = "",
            @SerializedName("webp_size")
            val webpSize: String = "",
            @SerializedName("webp")
            val webp: String = ""
        )
    }

    data class User(
        @SerializedName("username")
        val username: String = "") {
        @SerializedName("avatar_url")
        val avatarUrl: String = ""

        @SerializedName("profile_url")
        val profileUrl: String = ""

        @SerializedName("display_name")
        val displayName: String = ""

        @SerializedName("description")
        val description: String = ""
    }
}