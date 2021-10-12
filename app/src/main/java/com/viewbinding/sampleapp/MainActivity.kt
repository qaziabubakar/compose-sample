package com.viewbinding.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textState by remember {
                mutableStateOf("")
            }
            val mScope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textState,
                        label = {
                            Text(text = "Enter Name here!")
                        },
                        onValueChange = {
                            textState = it
                        })
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            mScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textState!")
                            }
                        }, modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Click Me!")
                    }
                }
            }
        }
    }
}
