package com.vasiliev.mymeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vasiliev.mymeds.courses.AddCourse
import com.vasiliev.mymeds.courses.CoursesRoutes
import com.vasiliev.mymeds.courses.CoursesList
import com.vasiliev.mymeds.courses.EditCourse
import com.vasiliev.mymeds.data.Repo
import com.vasiliev.mymeds.ui.theme.MyMedsTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMedsTheme {
                MainNavHost()
            }
        }
    }
}

@Composable
fun Drawer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost() {

    val navController = rememberNavController()

    Column {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = { Text(text = "MyMeds") }
        )

        NavHost(
            navController,
            startDestination = CoursesRoutes.coursesList()
        ) {
            composable(CoursesRoutes.coursesList()) { backStackEntry ->
                CoursesList(navController, backStackEntry.arguments?.getString("userId")!!)
            }
            composable(CoursesRoutes.newCourse()) { backStackEntry ->
                AddCourse(navController, Repo)
            }
            composable(CoursesRoutes.editCourseTemplate()) { backStackEntry ->
                EditCourse(
                    navController,
                    userId = backStackEntry.arguments?.getString("userId")!!,
                    courseId = backStackEntry.arguments?.getString("courseId")!!
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMedsTheme {
        MainNavHost()
    }
}

//    Column {
//        TextField(
//            value = "",
//            onValueChange = { },
//            label = { Text("Дата начала") }
//        )
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "Авторизация")
//        }
//    }