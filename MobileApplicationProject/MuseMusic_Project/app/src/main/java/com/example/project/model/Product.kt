package com.example.project.model

import android.icu.text.CaseMap.Title
import android.provider.ContactsContract.CommonDataKinds.Website
import javax.sql.StatementEvent

data class Product(
    val title: String,
    val photoUrl: String,
    val price: String,
    val website: String
    )