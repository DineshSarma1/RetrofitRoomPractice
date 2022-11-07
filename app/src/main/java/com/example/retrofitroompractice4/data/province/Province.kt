package com.example.retrofitroompractice4.data.province

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import kotlinx.parcelize.Parcelize

@Entity
data class Province(
    val name: String,
    val imageUrl: String,
    val description: String,
    @PrimaryKey val id: Int? = null
) {

    //To load image using glide
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }
}
