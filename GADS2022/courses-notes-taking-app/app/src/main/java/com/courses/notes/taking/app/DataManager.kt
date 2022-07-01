package com.courses.notes.taking.app

class DataManager {
    /*Fields*/
    // HashMap Generic Collection data structure, for key value-pair data with unique keys
    val courses = HashMap<String, CourseInfo>()

    // ArrayList Generic Collection for dynamic index based same items
    val note = ArrayList<NoteInfo>()

    /**
     * Initializer block
     */
    init {
        initCourses()
    }

    /*Methods*/
    private fun initCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_asyc", "Android Async programming and Services")
        courses.set(course.courseId, course)
    }
}