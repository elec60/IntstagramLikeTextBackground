package hashem.mousavi.intstagramliketextbackground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hashem.mousavi.intstagramliketextbackground.ui.theme.IntstagramLikeTextBackgroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntstagramLikeTextBackgroundTheme {
                Box(
                    modifier = Modifier
                        .background(Color.Black)
                        .padding(20.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    TextWithBackground()
                }
            }
        }
    }
}

