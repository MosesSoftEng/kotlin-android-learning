package com.courses.notes.taking.jetpackcomposeproject01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.SemanticsProperties.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Define a content block - setContent */
        setContent {
            /* Set text for content block using Text composable function */
//            Text("Hello World")

            /* Call a composable function*/
            MessageCard(message = "User")
        }
    }

    /* Define a composable function using @composable annotation */
    @Composable
    fun MessageCard(message: String) {
        /* Set text for content block */
        Text(text = "Hello World: $message")
    }
}