package com.courses.notes.taking.jetpackcomposeproject01

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.courses.notes.taking.jetpackcomposeproject01.ui.theme.JetpackComposeProject01Theme

class MainActivity : ComponentActivity() {
    data class Message(val author: String, val body: String)

    // Create a list of messages
    val messages = List(2) {
        Message("User0" ,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        Message("User1" ,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* Define a content block - setContent */
        setContent {
            // Apply app base theme to composable functions
            JetpackComposeProject01Theme {
                /* Set text for content block using Text composable function */
//            Text("Hello World")

                /* Call a composable function*/
//                MessageCard(Message("Android", "Jetpack Compose"))

                Conversation(messages)
            }
        }
    }

    @Composable
    private fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
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

            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }

            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )

            Column (
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            )
            {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondaryVariant, // Set title color
                    style = MaterialTheme.typography.body2
                )

                //  Add vertical space between.
                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    // surfaceColor color will be changing gradually from primary to surface
                    color = surfaceColor,
                    // animateContentSize will change the Surface size gradually
                    modifier = Modifier.animateContentSize().padding(1.dp)
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    /* To preview composable function in Android Design view use @Preview annotation
   on a function that does not take any parameters */
    @Preview(name = "Light Mode") // Ligth mode
    @Preview( // Dark mode
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewComposableFunctions() {
        // Apply app base theme to composable functions
        JetpackComposeProject01Theme {
            // Only visible in preview
//            MessageCard(Message("Preview Author", "Preview Body"))
            Conversation(messages)
        }
    }
}