package com.vasiliev.mymeds.courses

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun EditCourse(
    navController: NavController,
    userId: String,
    courseId: String
) {
    Text(text = "EDIT  course, id = $courseId")

}
