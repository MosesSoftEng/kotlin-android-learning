package com.courses.notes.taking.app

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DataManagerTest {
    @Before
    fun setUp() {
        // Ensure note collection starts in the same state always.
        DataManager.notes.clear()
        DataManager.initNotes()
    }

    @Test
    fun addNote() {
        val course = DataManager.courses.get("android_intents")!!
        val noteTitle = "Test note title"
        val noteText = "Test note body 1"

        val index = DataManager.addNote(course, noteTitle, noteText)
        val note = DataManager.notes[index]

        assertEquals(
            course, /* Expected value */
            note.courseInfo /* Actual or test value */
        )

        assertEquals(noteTitle, note.title)
        assertEquals(noteText, note.note)
    }

    @Test
    fun findSimilarNotes() {
        val course = DataManager.courses.get("android_intents")!!
        val noteTitle = "Test note title"
        val noteText1 = "Test note body 1"
        val noteText2 = "Test note body 2"

        val index1 = DataManager.addNote(course, noteTitle, noteText1)
        val index2 = DataManager.addNote(course, noteTitle, noteText2)

        val note1 = DataManager.findNote(course, noteTitle, noteText1)
        val foundIndex1 = DataManager.notes.indexOf(note1)
        assertEquals(index1, foundIndex1)

        val note2 = DataManager.findNote(course, noteTitle, noteText2)
        val foundIndex2 = DataManager.notes.indexOf(note2)
        assertEquals(index2, foundIndex2)
    }
}