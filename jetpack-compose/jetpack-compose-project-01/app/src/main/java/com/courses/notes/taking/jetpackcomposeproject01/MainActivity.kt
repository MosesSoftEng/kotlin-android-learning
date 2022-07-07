package com.courses.notes.taking.jetpackcomposeproject01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    data class Message(val author: String, val body: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Define a content block - setContent */
        setContent {
            /* Set text for content block using Text composable function */
//            Text("Hello World")

            /* Call a composable function*/
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }


    /* Define a composable function using @composable annotation */
    @Composable
    fun MessageCard(message: Message) {
        /* Set text for content block */
        Column {
            Text(text = message.author)
            Text(text = message.body)
        }
    }

    /* To preview composable function in Android Design view use @Preview annotation
   on a function that does not take any parameters */
    @Preview
    @Composable
    fun PreviewComposableFunctions(){
        // Only visible in preview
        MessageCard(Message("Preview Author", "Preview Body"))
    }
}