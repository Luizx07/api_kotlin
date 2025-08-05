package br.senai.sp.jandira.clienteapp
import androidx.compose.runtime.LaunchedEffect
import br.senai.sp.jandira.clienteapp.model.cliente
import br.senai.sp.jandira.clienteapp.service.Conexao
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
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
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClienteAppTheme {

                val cliente = cliente(
                    id = null,
                    nome = "cadastro do luiz",
                    email = "email@teste.com"
                )

                val conexao = Conexao().getClienteService()
                LaunchedEffect(Dispatchers.IO) {
                    conexao.cadastrarCliente(cliente).await()
                }
//                val requisicao = conexao.cadastrarCliente(cliente)
//
//                requisicao.enqueue(object : Callback<cliente> {
//                    override fun onResponse(call: Call<cliente>, response: Response<cliente>) {
//                        TODO("Not yet implemented")
//                        println("Http Code ${response.code()}")
//                    }
//
//                    override fun onFailure(call: Call<cliente>, t: Throwable) {
//                        TODO("Not yet implemented")
//                    }
//
//                })

                }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClienteAppTheme {
        Greeting("Android")
    }
}