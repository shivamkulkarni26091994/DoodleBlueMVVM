package com.doodleblue.application.model

import android.util.Log
import android.widget.ImageView

import androidx.databinding.BindingAdapter



import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


class DeveloperModel {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("rank")
    var rank: String? = null
    @SerializedName("symbol")
    var symbol: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("maxSupply")
    var maxSupply: String? = null
    @SerializedName("marketCapUsd")
    var marketCapUsd: String? = null
    @SerializedName("volumeUsd24Hr")
    var volumeUsd24Hr: String? = null
    @SerializedName("priceUsd")
    var priceUsd: String? = null
    @SerializedName("changePercent24Hr")
    var changePercent24Hr: String? = null
    @SerializedName("vwap24Hr")
    var vwap24Hr: String? = null








   /* companion object  {


        @JvmStatic
        @BindingAdapter("avatar_url")
        fun loadImage(imageView: ImageView, imageURL: String) {

            Log.e("imsgeurl",imageURL)
            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageURL)

                .into(imageView)
        }

    }
*/


}
