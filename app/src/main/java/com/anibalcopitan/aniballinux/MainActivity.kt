package com.anibalcopitan.aniballinux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anibalcopitan.aniballinux.ui.theme.MyLinuxTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLinuxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Pepe $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLinuxTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF050505))
            .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {

        // TOP LABEL
        Text(
            text = "PERSONAL SYSTEM",
            color = Color(0xFF00FF99),
            fontSize = 11.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(22.dp))



        // HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                // BIG TITLE
                Text(
                    text = "ANIBAL",
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 42.sp
                )

                Text(
                    text = "LINUX",
                    color = Color(0xFF00FF99),
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Black,
                    lineHeight = 42.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                // STATUS
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                Color(0xFF00FF99),
                                CircleShape
                            )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "ONLINE",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    )

                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "LINUX CREATOR • ANDROID DEV",
                    color = Color(0xFFBDBDBD),
                    fontSize = 13.sp,
                    letterSpacing = 1.sp,
                    lineHeight = 24.sp
                )

            }

            Spacer(modifier = Modifier.width(18.dp))

            // PROFILE IMAGE
            Box {

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,

                    modifier = Modifier
                        .size(92.dp)
                        .clip(RoundedCornerShape(2.dp)),

                    contentScale = ContentScale.Crop
                )

                // GREEN CORNER DETAIL
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(14.dp)
                        .background(Color(0xFF00FF99))
                )

            }

        }

        Spacer(modifier = Modifier.height(40.dp))

        // MAIN PANEL
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0D0D0D))
                .border(
                    width = 1.dp,
                    color = Color(0xFF1E1E1E)
                )
                .padding(22.dp)
        ) {

            Column {

                Text(
                    text = "ABOUT",
                    color = Color(0xFF00FF99),
                    fontSize = 11.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text =
                        "🐧 Linux Lover\n\n" +
                                "📱 Android Creator\n\n" +
                                "⚡ Building ideas everyday",

                    color = Color.White,
                    fontSize = 20.sp,
                    lineHeight = 38.sp,
                    fontWeight = FontWeight.Medium
                )

            }

        }

        Spacer(modifier = Modifier.height(18.dp))

        // TERMINAL BLOCK
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Color(0xFF00FF99)
                )
                .padding(22.dp)
        ) {

            Column {

                Text(
                    text = "[anibal@linux]$ whoami",
                    color = Color(0xFF00FF99),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "aniballinux",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "",
                    color = Color(0xFF00FF99),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 16.sp
                )

            }

        }

        Spacer(modifier = Modifier.height(42.dp))

        Column {

            // Tu contenido

            BannerAd()
        }

        Spacer(modifier = Modifier.height(42.dp))

        // FOOTER
        Text(
            text = "BUILT FROM PERU 🇵🇪 WITH LINUX",
            color = Color(0xFF666666),
            fontSize = 10.sp,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

    }

}