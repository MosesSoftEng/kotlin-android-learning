package com.courses.notes.taking.jetpackcomposeproject01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.courses.notes.taking.jetpackcomposeproject01.ui.theme.JetpackComposeProject01Theme

class MainActivity : ComponentActivity() {
    data class Message(val author: String, val body: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Define a content block - setContent */
        setContent {
            // Apply app base theme to composable functions
            JetpackComposeProject01Theme {
                /* Set text for content block using Text composable function */
//            Text("Hello World")

                /* Call a composable function*/
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }


    /* Define a composable function using @composable annotation */
    @Composable
    fun MessageCard(message: Message) {
        /* Set text for content block */
        Row (
            // Add padding using modifier
            modifier = Modifier.padding(all = 8.dp)

        ){
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp) // Image size
                    .clip(CircleShape) // Image circle shape
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape) // Add border to image
            )

            //  Add horizontal space between.
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondaryVariant // Set title color
                )

                //  Add vertical space between.
                Spacer(modifier = Modifier.height(8.dp))

                Text(text = message.body)
            }
        }
    }

    /* To preview composable function in Android Design view use @Preview annotation
   on a function that does not take any parameters */
    @Preview
    @Composable
    fun PreviewComposableFunctions() {
        // Apply app base theme to composable functions
        JetpackComposeProject01Theme {
            // Only visible in preview
            MessageCard(Message("Preview Author", "Preview Body"))
        }
    }
}