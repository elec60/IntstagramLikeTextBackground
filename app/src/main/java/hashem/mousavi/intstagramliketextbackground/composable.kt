package hashem.mousavi.intstagramliketextbackground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

@Composable
fun TextWithBackground() {
    var textLayout by remember {
        mutableStateOf<TextLayoutResult?>(null)
    }
    val padding by remember {
        mutableStateOf(20.dp)
    }

    var text by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .background(
                color = Color.White,
                shape = TextBackgroundShape(
                    textLayout, with(LocalDensity.current) { padding.toPx() })
            ),
        textStyle = TextStyle(color = Color.Blue, textAlign = TextAlign.Center, fontSize = 20.sp),
        cursorBrush = SolidColor(Color.Magenta),
        onTextLayout = {
            textLayout = it
        }
    )
}

class TextBackgroundShape(
    private val textLayoutResult: TextLayoutResult?,
    private val padding: Float,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val path = Path().apply {
            textLayoutResult?.let { result ->
                for (line in 0 until result.lineCount) {
                    val left = result.getLineLeft(line)
                    val top = result.getLineTop(line)
                    val right = result.getLineRight(line)
                    val bottom = result.getLineBottom(line)
                    moveTo(x = left - padding / 2, y = bottom)
                    arcTo(
                        Rect(
                            topLeft = Offset(x = left - padding / 2, y = top),
                            bottomRight = Offset(x = left + padding / 2, y = bottom)
                        ),
                        startAngleDegrees = 90f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = true
                    )
                    lineTo(x = right, y = top)
                    arcTo(
                        Rect(
                            topLeft = Offset(x = right - padding / 2, y = top),
                            bottomRight = Offset(x = right + padding / 2, y = bottom)
                        ),
                        startAngleDegrees = -90f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = true
                    )
                    lineTo(x = left, y = bottom)
                    close()
                }
            }
        }
        return Outline.Generic(path)
    }

}