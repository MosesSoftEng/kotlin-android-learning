package com.courses.notes.taking.app

import org.junit.Assert.*

import org.junit.Test

class DataManagerTest {

    @Test
    fun addNote() {
        val courseInfo = DataManager.courses.get("android_intents") !! // Throw exception if null
        val noteTitle = "This is a test note title"
        val noteText = "This is a test note text"

        val index = DataManager.addNote(courseInfo, noteTitle, noteText)
        val note = DataManager.notes[index]

        assertEquals(
            courseInfo, /* Expected value */
            note.courseInfo /* Actual or test value */
        )

        assertEquals(noteTitle, note.title)
        assertEquals(noteText, note.note)
    }
}