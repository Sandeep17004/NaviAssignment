package com.example.naviassignment.utils

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.naviassignment.R
import com.example.naviassignment.utils.BindingAdapter.requiredTimeFormatter
import com.example.naviassignment.utils.Constants.Companion.SERVER_DATE_TIME_FORMAT
import com.example.naviassignment.utils.Constants.Companion.UI_DATE_FORMAT
import com.example.naviassignment.utils.Constants.Companion.UI_TIME_FORMAT
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*

object BindingAdapter {
    private val serverDateFormatter = SimpleDateFormat(SERVER_DATE_TIME_FORMAT, Locale.getDefault())
    private val requiredDateFormatter = SimpleDateFormat(UI_DATE_FORMAT, Locale.getDefault())
    private val requiredTimeFormatter = SimpleDateFormat(UI_TIME_FORMAT, Locale.getDefault())

    @JvmStatic
    @BindingAdapter("commitAuthorImage")
    fun CircleImageView.bindProfileImage(profileUrl: String) {
        val requestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_profile_placeholder)
            .error(R.drawable.ic_profile_placeholder)
        Glide.with(this).load(profileUrl).apply(requestOptions).into(this)
    }

    @JvmStatic
    @BindingAdapter("formatServerDate", "isCreated")
    fun AppCompatTextView.bindServerDate(serverDate: String, isCreated: Boolean) {
        kotlin.runCatching { serverDateFormatter.parse(serverDate) }.onSuccess {
            it?.let { date ->
                this.apply {
                    text = if (isCreated) {
                        this.context.getString(
                            R.string.created_on,
                            requiredDateFormatter.format(date), requiredTimeFormatter.format(date)
                        )
                    } else {
                        this.context.getString(
                            R.string.closed_on,
                            requiredDateFormatter.format(date), requiredTimeFormatter.format(date)
                        )
                    }
                }
            }
        }
    }
}
