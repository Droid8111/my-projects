package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                val initialRandInt = Random.nextInt(3, 6)
                Lemonade(initialRandInt = initialRandInt) {
                    println("Column clicked")
                }
            }
        }
    }
}

@Composable
fun Lemonade(initialRandInt: Int, onClick: () -> Unit = {}) {
    val click = remember { mutableIntStateOf(0) }
    val next = remember { mutableIntStateOf(0) }
    val randomNumber = remember { mutableIntStateOf(initialRandInt) }

    when (click.intValue) {
        0 -> next.intValue = 0
        1 -> next.intValue = 1
        randomNumber.intValue -> next.intValue = 2
        randomNumber.intValue + 1 -> next.intValue = 3
        randomNumber.intValue + 2 -> reset(click, next, randomNumber)
    }


    val textState = when (next.intValue) {
        0 -> stringResource(id = R.string.tree) // "Tap the tree to get lemons"
        1 -> stringResource(id = R.string.lemon)// "Tap the lemon to squeeze it"
        2 -> stringResource(id = R.string.lemonade)// "Tap the glass to drink"
        else -> stringResource(id = R.string.drink)// "Drink"
    }
    val imageState = when (next.intValue) {
        0 -> painterResource(id = R.drawable.lemon_tree) // "Tap the tree to get lemons"
        1 -> painterResource(id = R.drawable.lemon_squeeze)// "Tap the lemon to squeeze it"
        2 -> painterResource(id = R.drawable.lemon_drink)// "Tap the glass to drink"
        else -> painterResource(id = R.drawable.lemon_restart)// "Drink"
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                click.value += 1
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Lemonade",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .background(Color(0xFFEBE195))
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 16.dp),


            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(180.dp))

        Box(modifier = Modifier.align(Alignment.CenterHorizontally), contentAlignment = Alignment.Center) {
            val image = R.drawable.ic_launcher_background
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(256.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Image(
                painter = imageState,
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(256.dp)
            )
        }
        Text(
            text = textState,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}


fun reset(click: MutableState<Int>, next: MutableState<Int>, randomNumber: MutableState<Int>) {
    click.value = 0
    next.value = 0
    randomNumber.value = Random.nextInt(3, 6) // Generate a new random number
}

@Preview(showBackground = true)
@Composable
fun PreviewLemonade() {
    val initialRandInt = Random.nextInt(3, 6)
    Lemonade(initialRandInt = initialRandInt) {
    }
}