package com.example.business_card

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.Business_cardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.input.pointer.pointerHoverIcon
import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Business_cardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .height(116.dp),
            )

            Text(
                text = "Jennifer Doe",
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
                fontSize = 44.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
        // Добавляем отступ снизу для красоты
        GreetingContact(modifier = Modifier.padding(bottom = 32.dp))
    }
}


@Composable
fun GreetingContact(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null,
                modifier = Modifier.padding(end = 24.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "+11 (123) 444 555 666",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(
                imageVector = Icons.Rounded.Share,
                contentDescription = null,
                modifier = Modifier.padding(end = 24.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "@AndroidDev",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = null,
                modifier = Modifier.padding(end = 24.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "www.google.com",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Business_cardTheme(darkTheme = false) {
        Greeting()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun GreetingPreviewDark() {
    Business_cardTheme(darkTheme = true) {
        Greeting()
    }
}
