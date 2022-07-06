package com.courses.notes.taking.app

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
    private fun initNotes() {
        var note = NoteInfo(
            CourseInfo("android_intents", "Android Programming with Intents"),
            "My note title",
            "This is a sample note.")

        notes.add(note)
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