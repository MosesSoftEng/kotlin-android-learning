package com.courses.notes.taking.app

import android.icu.text.CaseMap

/**
 * The object singleton implementation. Single class implementation
 * Singleton make one copy that can be used in different activities.
 */
object DataManager {
    /*Fields*/
    // HashMap Generic Collection data structure, for key value-pair data with unique keys
    val courses = HashMap<String, CourseInfo>()

    // ArrayList Generic Collection for dynamic index based same items
    val notes = ArrayList<NoteInfo>()

    /**
     * Initializer block, block of code that will run on object creation.
     */
    init {
        initCourses()
        initNotes()
    }

    /**
     * Prepare notes.
     */
    public fun initNotes() {
        notes.add(NoteInfo(
            CourseInfo("android_intents", "Android Programming with Intents"),
            "My note title",
            "This is a sample note.")
        )

        notes.add(NoteInfo(
            CourseInfo("android lifecycle", "Android lifecycle"),
            "My note title 2",
            "This is a sample note 2")
        )
    }

    /**
     * Prepare courses.
     */
    private fun initCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_asyc", "Android Async programming and Services")
        courses.set(course.courseId, course)
    }

    /**
     * Function to add new note.
     */
    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        val note  = NoteInfo(course, noteTitle, noteText)
        notes.add(note)

        return notes.lastIndex
    }

    /**
     * Search for a note
     */
    fun findNote(course: CourseInfo, noteTitle: String, noteText: String): NoteInfo? {
        for(note in notes)
                if(course == note.courseInfo && noteTitle == note.title &&
                    noteText == note.note)
                    return note
        return null
    }
}

/**
 * The class type implementation
 */
//class DataManager {
//    /*Fields*/
//    // HashMap Generic Collection data structure, for key value-pair data with unique keys
//    val courses = HashMap<String, CourseInfo>()
//
//    // ArrayList Generic Collection for dynamic index based same items
//    val note = ArrayList<NoteInfo>()
//
//    /**
//     * Initializer block
//     */
//    init {
//        initCourses()
//    }
//
//    /*Methods*/
//    private fun initCourses() {
//        var course = CourseInfo("android_intents", "Android Programming with Intents")
//        courses.set(course.courseId, course)
//
//        course = CourseInfo("android_asyc", "Android Async programming and Services")
//        courses.set(course.courseId, course)
//    }
//}