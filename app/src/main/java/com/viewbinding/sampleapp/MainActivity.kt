package com.viewbinding.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 50.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("S")
                        }
                        append("ome")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 50.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("N")
                        }
                        append("ew")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontSize = 50.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("T")
                        }
                        append("ext")
                    },
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline,
                    color = Color.White,
                    fontSize = 42.sp
                )
            }
        }
    }
}