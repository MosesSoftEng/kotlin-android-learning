package com.courses.notes.taking.app

/*
 * Models structures using class type
 * Use kotlin file to use multiple classes in one file
 */

/**
 * Class CourseInfo, class type for notes (Model)
 * Has default constructor accepting two parameters
 * that cannot be changed val keyword.
 * @param courseId
 * @param title
 */
//class CourseInfo(val courseId: String, val title: String) {
//    /* Override toString default method */
//    override fun toString(): String {
//        return title
//    }
//}

data class CourseInfo(val courseId: String, val title: String) {
    /* Override toString default method */
    override fun toString(): String {
        return title
    }
}

/* Class type model*/
//class NoteInfo(var courseInfo: CourseInfo, var title: String, var note: String) {
//    override fun toString(): String {
//        return title
//    }
//}

/**
 * Data class
 * Similar to class type but with functions;
 *  copy(), equals() and hashCode() pair, toString() created form of the primary constructor and
 *  componentN() functions - used for destructuring declarations.
 */
//data class NoteInfo(var courseInfo: CourseInfo, var title: String, var note: String)  // Not nullable
//data class NoteInfo(var courseInfo: CourseInfo?, var title: String?, var note: String?)  // Nullable
data class NoteInfo(var courseInfo: CourseInfo? = null, var title: String? = null, var note: String? = null) // Set null as default value