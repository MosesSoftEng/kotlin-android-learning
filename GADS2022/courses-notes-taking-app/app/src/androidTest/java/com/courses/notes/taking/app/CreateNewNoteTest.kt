package com.courses.notes.taking.app

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) // Specify test runner
class CreateNewNoteTest {

    /* Setup android activity */
    @Rule // Tell system about this rule
    @JvmField // Tell system to handle this field as a java field
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Test // Mark function as test
    fun createNewNote() {
        val course = DataManager.courses["android_intents"]
        val noteTitle = "Test note title"
        val noteText = "Test note text"

        // Click fab
        onView(withId(R.id.fab))    // Select View
            .perform(click())   // Perform action on the selected view

        // Input text in textTitle
        onView(withId(R.id.noteTitleEditText))
            .perform(typeText(noteTitle))

        onView(withId(R.id.noteTextEditText))
            .perform(
                typeText(noteText),
                closeSoftKeyboard()         /* Close keyboard */
            )

        /* View with Adapters */
        // Select spinner
        onView(withId(R.id.spinnerCourses))
            .perform(click())

        // Select data in spinner
        onData(
            allOf(
                instanceOf(CourseInfo::class.java),
                equalTo(course)
            )
        ).perform(click())

        // Simulate back press
        pressBack()

        /* Test logic */
        val note = DataManager.notes.last()

        Assert.assertEquals(
            course, /* Expected value */
            note.courseInfo /* Actual or test value */
        )
        Assert.assertEquals(noteTitle, note.title)
        Assert.assertEquals(noteText, note.note)
    }
}