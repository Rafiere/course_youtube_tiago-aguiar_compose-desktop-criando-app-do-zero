import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

private const val WIDTH = 1280
private const val HEIGHT = 720
enum class Answer {
    YES, NO, NONE
}

@Composable //Precisamos anotar a função com @Composable para que o Compose saiba que ela é uma função de composição.
//@Preview Serve para verificarmos na janela ao lado.
fun App() {
    var answerYes by remember { mutableStateOf(Answer.NONE) } //Todas as vezes que o estado for alterado, o Compose irá redesenhar o componente.

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color(.95F, .95F, .95F))
        ) { //O modificador é o que modificará as proprieedades do componente.
            Text(
                "Olá, tudo bem?",
                modifier = Modifier.align(Alignment.Center) //Estamos alinhando o texto no centro.
                    .offset(y = (-50).dp) //Estamos deslocando o texto 50dp para cima.
            )
            Button(onClick = {
                answerYes = Answer.YES
            }, modifier = Modifier.align(Alignment.Center).offset(x = (-50).dp)) {
                Text("Sim!")
            }

            Button(onClick = {
                answerYes = Answer.NO
            }, modifier = Modifier.align(Alignment.Center).offset(x = (50).dp)) {
                Text("Não!")
            }

            if (answerYes.equals(Answer.YES)) {
                Text("Ainda bem que você está bem!", modifier = Modifier.align(Alignment.Center).offset(y = (50).dp))
            } else if(answerYes.equals(Answer.NO)) {
                Text("Que pena que você não está bem!", modifier = Modifier.align(Alignment.Center).offset(y = (50).dp))
            }
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(size = DpSize(width = WIDTH.dp, height = HEIGHT.dp)),
        resizable = false,
        title = "Você está bem?",
    ) {
        App()
    }
}
