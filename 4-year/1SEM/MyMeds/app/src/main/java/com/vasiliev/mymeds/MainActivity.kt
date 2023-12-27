package com.vasiliev.mymeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vasiliev.mymeds.ui.theme.MyMedsTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMedsTheme {
                Main()
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
fun Main() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "MyMeds") }
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Column {
                Text(
                    text = "asdfasd",
                    modifier = Modifier.padding(top = contentPadding.calculateTopPadding())
                )

            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                Modifier.align(alignment = Alignment.BottomEnd)
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMedsTheme {
        Main()
    }
}