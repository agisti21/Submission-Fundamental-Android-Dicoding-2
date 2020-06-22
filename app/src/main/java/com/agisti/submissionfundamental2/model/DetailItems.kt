package com.agisti.submissionfundamental2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DetailItems(
    var avatar: String?,
    var username: String?,
    var company: String?,
    var location: String?
): Parcelable