package com.viewbinding.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlin.random.Random

/**
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                val text = remember {
                    mutableStateOf("1")
                }
                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    {
                        color.value = it
                    },
                    {
                        text.value = it
                    })
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(color.value),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text.value, color = Color.Red,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit,
    updateText: (String) -> Unit
) {
    Box(modifier = modifier
        .background(color = Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
            updateText(
                Random
                    .nextInt()
                    .toString()
            )
        })
}