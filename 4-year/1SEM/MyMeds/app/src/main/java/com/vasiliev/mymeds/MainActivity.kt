package com.vasiliev.mymeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vasiliev.mymeds.ui.theme.MyMedsTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMedsTheme {
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
                    Text(text = "asdfasd", modifier = Modifier.padding(top = contentPadding.calculateTopPadding()))
//                    Main("Android")
                }

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

@Composable
fun Main(name: String, modifier: Modifier = Modifier) {
    Column {
        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Дата начала") }
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Авторизация")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyMedsTheme {
        Main("Android")
    }
}