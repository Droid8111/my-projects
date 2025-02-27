package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(red = 190f / 255f, green = 255f / 255f, blue = 210f / 255f)

                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    // Main screen container
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Centered Image
            Image(
                painter = painterResource(id = R.drawable.android_logo), // Replace with your drawable
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Black)

            )

            // Name Text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Jennifer Doe",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // Subtitle
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(24.dp))


        }
        Column(
            //horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
            //.fillMaxWidth()
        ) {
            ContactInfoRow(icon = Icons.Default.Call,info = "+11 (123) 444 555 666")
//                Spacer(modifier = Modifier.height(8.dp))
            ContactInfoRow(icon = Icons.Default.AccountCircle, info = "@AndroidDev")
//                Spacer(modifier = Modifier.height(8.dp))
            ContactInfoRow(icon = Icons.Default.Email, info = "jen.doe@android.com")
        }
    }

}

@Composable
fun ContactInfoRow(icon: ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.DarkGray,
            modifier = Modifier.size(40.dp)
                .padding(bottom = 16.dp, end = 8.dp)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = info,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCardScreen()
}