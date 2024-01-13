package com.vasiliev.mymeds.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vasiliev.mymeds.presentation.courses.CoursesRoutes

@Composable
fun SignInScreen(
    navController: NavController,
) {
    var email = ""
    var pass = ""

    Column {
        Text(text = "Авторизация")
        TextField(
            label = { Text(text = "Email") },
            value = email,
            onValueChange = { email = it }
        )
        TextField(
            label = { Text(text = "Пароль") },
            value = pass,
            onValueChange = { pass = it }
        )
        ElevatedButton(onClick = {
            Firebase.auth
                .createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful.not()) {
                        Toast.makeText(
                            //wip
                            LocalContext.current,
                            "Ошибка авторизации",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

            navController.navigate(route = CoursesRoutes.coursesList())
        }) {
            Text(text = "Сохранить")
        }
    }
}