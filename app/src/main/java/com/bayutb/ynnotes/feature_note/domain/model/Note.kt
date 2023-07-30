package com.bayutb.ynnotes.feature_note.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bayutb.ynnotes.ui.theme.BabyBlue
import com.bayutb.ynnotes.ui.theme.LightGreen
import com.bayutb.ynnotes.ui.theme.RedOrange
import com.bayutb.ynnotes.ui.theme.RedPink
import com.bayutb.ynnotes.ui.theme.Violet

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "timeStamp")
    val timeStamp: Long,
    @ColumnInfo(name = "color")
    val color: Int,
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)