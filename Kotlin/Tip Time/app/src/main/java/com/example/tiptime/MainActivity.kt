package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptime.ui.theme.TipTimeTheme
import kotlinx.coroutines.awaitAll
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var amountInput = remember { mutableStateOf("0") }
    var tipPercent = remember { mutableStateOf("0.0") }
    var roundUp = remember { mutableStateOf(false) }
    val amount = amountInput.value.toDoubleOrNull() ?: 0.0
    val tipPercentValue = tipPercent.value.toDoubleOrNull() ?: 15.0
    val tip = calculateTip(amount, tipPercentValue, roundUp.value)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(amountInput.value,
                        onValueChange = {amountInput.value = it},
                        Modifier.padding(bottom = 32.dp).fillMaxWidth(),
                        text = stringResource(R.string.bill_amount),
                        image = R.drawable.money,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next)
        )
        EditNumberField(tipPercent.value,
            onValueChange = {tipPercent.value = it},
            Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            text = stringResource(R.string.tip_percent),
            image = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType= KeyboardType.Number,
                imeAction = ImeAction.Done)
        )
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.Round_Up),
                textAlign = TextAlign.Start,
                modifier = Modifier
                                .padding(end = 8.dp)
            )
            Roundthetip(
                roundUp = roundUp.value,
                onRoundUpChanged = { roundUp.value = it },
                modifier = Modifier
            )

        }
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */

@Composable
fun Roundthetip(roundUp: Boolean,
                onRoundUpChanged: (Boolean) -> Unit,
                modifier: Modifier = Modifier) {
    Switch(
        checked = roundUp,
        onCheckedChange = onRoundUpChanged
    )
}

@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercent: Double = 0.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun EditNumberField(value: String,
                    onValueChange: (String) -> Unit,
                    modifier: Modifier = Modifier,
                    text: String,
                    image: Int,
                    keyboardOptions: KeyboardOptions
                    ) {
    TextField(
        leadingIcon = { Icon(painter = painterResource(id = image), null)},
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout()
    }
}