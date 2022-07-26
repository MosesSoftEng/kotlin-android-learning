package com.courses.notes.taking.app

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) // Specify test runner
class NextThroughNotesTest {

    /* Setup android activity */
    @Rule // Tell system about this rule
    @JvmField // Tell system to handle this field as a java field
    val noteListActivity = ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun nextThroughNotes() {
        /* Select data in spinner,
                no initial click like in spinner */
        Espresso.onData(
            CoreMatchers.allOf(
                CoreMatchers.instanceOf(NoteInfo::class.java),
                CoreMatchers.equalTo(
                    DataManager.notes[0]
                )
            )
        ).perform(click())

        /* Loop each note */
        for(index in 0..DataManager.notes.lastIndex) {
            val note = DataManager.notes[index]

            onView(withId(R.id.spinnerCourses)).check(
                matches(withSpinnerText(note.courseInfo?.title)) // Check for match
            )

            onView(withId(R.id.noteTitleEditText)).check(
                matches(withText(note.title)) // Check for match
            )

            onView(withId(R.id.noteTextEditText)).check(
                matches(withText(note.note)) // Check for match
            )

            /* Menu tests */
            if(index != DataManager.notes.lastIndex) {
                // Not on last note

                onView(
                    allOf( // View should be enabled
                        withId(R.id.action_next),
                        isEnabled()
                    )
                ).perform(click())

            }

            /* Check if next button is not enabled */
            onView(withId(R.id.action_next))
//                .check(matches(not(isEnabled())))
                .check(matches(isEnabled()))
        }
    }
}