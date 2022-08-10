package com.example.healthjoy.Model


import com.google.gson.annotations.SerializedName

data class GliphyResponseModel(
    @SerializedName("data")
    val listData: List<GliphyData> = listOf(),
    @SerializedName("pagination")
    val pagination: Pagination = Pagination()
)
{
    data class GliphyData(
        @SerializedName("type")
        val type: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("url")
        val url: String = "",
        @SerializedName("slug")
        val slug: String = "",
        @SerializedName("embed_url")
        val embedUrl: String = "",
        @SerializedName("username")
        val username: String = "",
        @SerializedName("source")
        val source: String = "",
        @SerializedName("title")
        val title: String = "",
        @SerializedName("rating")
        val rating: String = "",
        @SerializedName("images")
        val images: Images = Images(),
        @SerializedName("user")
        val user: User = User()
    ) {
        data class Images(
            @SerializedName("original")
            val original: Original = Original(),
            @SerializedName("downsized")
            val downsized: Downsized = Downsized(),
            @SerializedName("downsized_large")
            val downsizedLarge: DownsizedLarge = DownsizedLarge(),
            @SerializedName("downsized_medium")
            val downsizedMedium: DownsizedMedium = DownsizedMedium(),
            @SerializedName("downsized_small")
            val downsizedSmall: DownsizedSmall = DownsizedSmall(),
            @SerializedName("downsized_still")
            val downsizedStill: DownsizedStill = DownsizedStill(),
            @SerializedName("original_still")
            val originalStill: OriginalStill = OriginalStill(),
            @SerializedName("original_mp4")
            val originalMp4: OriginalMp4 = OriginalMp4(),
            @SerializedName("preview")
            val preview: Preview = Preview(),
            @SerializedName("preview_gif")
            val previewGif: PreviewGif = PreviewGif(),
            @SerializedName("preview_webp")
            val previewWebp: PreviewWebp = PreviewWebp(),
            @SerializedName("480w_still")
            val wStill: WStill = WStill(),
            @SerializedName("hd")
            val hd: Hd = Hd()
        )
        {
            data class Original(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = "",
                @SerializedName("mp4_size")
                val mp4Size: String = "",
                @SerializedName("mp4")
                val mp4: String = "",
                @SerializedName("webp_size")
                val webpSize: String = "",
                @SerializedName("webp")
                val webp: String = "",
                @SerializedName("frames")
                val frames: String = "",
                @SerializedName("hash")
                val hash: String = ""
            )

            data class Downsized(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class DownsizedLarge(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class DownsizedMedium(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class DownsizedSmall(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("mp4_size")
                val mp4Size: String = "",
                @SerializedName("mp4")
                val mp4: String = ""
            )

            data class DownsizedStill(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class OriginalStill(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class OriginalMp4(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("mp4_size")
                val mp4Size: String = "",
                @SerializedName("mp4")
                val mp4: String = ""
            )

            data class Preview(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("mp4_size")
                val mp4Size: String = "",
                @SerializedName("mp4")
                val mp4: String = ""
            )

            data class PreviewGif(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class PreviewWebp(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class WStill(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("size")
                val size: String = "",
                @SerializedName("url")
                val url: String = ""
            )

            data class Hd(
                @SerializedName("height")
                val height: String = "",
                @SerializedName("width")
                val width: String = "",
                @SerializedName("mp4_size")
                val mp4Size: String = "",
                @SerializedName("mp4")
                val mp4: String = ""
            )
        }

        data class User(
            @SerializedName("avatar_url")
            val avatarUrl: String = "",
            @SerializedName("profile_url")
            val profileUrl: String = "",
            @SerializedName("username")
            val username: String = "",
            @SerializedName("display_name")
            val displayName: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("instagram_url")
            val instagramUrl: String = "",
            @SerializedName("website_url")
            val websiteUrl: String = "",
            @SerializedName("is_verified")
            val isVerified: Boolean = false
        )
    }

    data class Pagination(
        @SerializedName("total_count")
        val totalCount: Int = 0,
        @SerializedName("count")
        val count: Int = 0,
        @SerializedName("offset")
        val offset: Int = 0
    )
}