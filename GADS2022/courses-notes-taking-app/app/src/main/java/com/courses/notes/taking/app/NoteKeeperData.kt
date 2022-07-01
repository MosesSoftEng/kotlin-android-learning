package com.courses.notes.taking.app

/*
 * Use kotlin file to use multiple classes in one file
 */

/**
 * Class CourseInfo, class type for notes (Model)
 * Has default constructor accepting two parameters
 * that cannot be changed val keyword.
 * @param courseId
 * @param title
 */
class CourseInfo(val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

class NoteInfo(var courseInfo: CourseInfo, var title: String, var note: String)