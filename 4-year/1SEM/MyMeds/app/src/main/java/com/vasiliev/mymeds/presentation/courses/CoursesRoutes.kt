package com.vasiliev.mymeds.presentation.courses

object CoursesRoutes {

    fun newCourse() = "courses/new"

    fun editCourseTemplate() = "courses/edit/{courseId}"
    fun toEditCourse(courseId: String) = "courses/edit/{courseId}"

    fun coursesList() = "courses/list"
}