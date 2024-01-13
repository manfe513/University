package com.vasiliev.mymeds.courses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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

@Composable
fun CoursesList(
    navController: NavController,
    userId: String
) {
    Text(text = "courses")

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column {
//            Text(
//                text = "asdfasd",
//                modifier = Modifier.padding(top = contentPadding.calculateTopPadding())
//            )

        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            Modifier.align(alignment = Alignment.BottomEnd)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}
