package com.vasiliev.mymeds.presentation.courses

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vasiliev.mymeds.data.Repo
import com.vasiliev.mymeds.data.model.Course

@Composable
fun CoursesList(
    navController: NavController,
    repo: Repo,
    userId: String
) {
    Text(text = "courses")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            repo.getCourses(userId)
                .forEach { CourseItem(it, navController) }
        }
        FloatingActionButton(
            onClick = { navController.navigate(route = CoursesRoutes.newCourse()) },
            Modifier.align(alignment = Alignment.BottomEnd)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}

@Composable
fun CourseItem(
    course: Course,
    navController: NavController
) {
    Row(
        modifier = Modifier.clickable {
            navController.navigate(route = CoursesRoutes.toEditCourse(courseId = course.id))
        }
    ) {
        Column {
            Text(text = course.drug.name)
            Text(text = course.drug.description)
            Text(text = course.drug.type.name)
            Text(text = course.drugUseType.name)
        }
        Column {
            Text(text = course.dateStart.toString())
            Text(text = course.dateEnd.toString())
        }
    }
}