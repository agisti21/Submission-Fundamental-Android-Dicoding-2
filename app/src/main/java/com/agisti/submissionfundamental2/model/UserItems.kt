package com.agisti.submissionfundamental2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserItems(
    var avatar: String?,
    var username: String?
):Parcelable