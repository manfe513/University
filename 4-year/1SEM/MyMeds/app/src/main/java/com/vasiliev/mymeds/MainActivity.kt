package com.vasiliev.mymeds

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vasiliev.mymeds.data.Repo
import com.vasiliev.mymeds.presentation.courses.CourseInfoScreen
import com.vasiliev.mymeds.presentation.courses.CoursesList
import com.vasiliev.mymeds.presentation.courses.CoursesRoutes
import com.vasiliev.mymeds.presentation.login.LoginRoutes
import com.vasiliev.mymeds.presentation.theme.MyMedsTheme

class MainActivity : ComponentActivity() {

    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private var showOneTapUI = true

    init {
        appContext = applicationContext
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMedsTheme {
                MainNavHost()
            }
        }
    }

    companion object {
        var appContext: Context? = null
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
            title = { Text(text = "MyMeds") },
            actions = {
                when (Firebase.auth.currentUser == null) {
                    true -> LoginAction(navController)
                    false -> LogoutAction()
                }
            }
        )

        NavHost(
            navController,
            startDestination = CoursesRoutes.coursesList()
        ) {
            composable(CoursesRoutes.coursesList()) { backStackEntry ->
                CoursesList(navController, backStackEntry.arguments?.getString("userId")!!)
            }
            composable(CoursesRoutes.newCourse()) { backStackEntry ->
                CourseInfoScreen(navController, Repo)
            }
            composable(CoursesRoutes.editCourseTemplate()) { backStackEntry ->
                CourseInfoScreen(
                    navController,
                    repo = Repo,
                    courseId = backStackEntry.arguments?.getString("courseId")!!
                )
            }
        }
    }
}

@Composable
fun LoginAction(navController: NavController) {
    IconButton(onClick = {
        navController.navigate(route = LoginRoutes.LOGIN)
    }) {
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "Войти"
        )
    }
}

@Composable
fun LogoutAction() {
    IconButton(onClick = {
        Firebase.auth.signOut()
    }) {
        Icon(
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = "Выйти"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMedsTheme {
        MainNavHost()
    }
}