package br.senai.sp.jandira.clienteapp.screens.cliente

import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.clienteapp.model.cliente
import br.senai.sp.jandira.clienteapp.service.Conexao
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

@Composable
fun ClienteForm(padding: PaddingValues, controleNavegacao: NavHostController?) {

    var NomeCliente by remember { mutableStateOf("") }
    var EmailCliente by remember { mutableStateOf("") }
    var isNomeError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }

    var mostrarMensagemSucesso by remember { mutableStateOf(false) }

    fun validar():Boolean{
        isNomeError = NomeCliente.length < 3
        isEmailError = !Patterns.EMAIL_ADDRESS.matcher(EmailCliente).matches()
        return !isNomeError && !isEmailError
    }

    val clienteApi = Conexao().getClienteService()

    Surface(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "novo cliente",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = NomeCliente,
            onValueChange = { NomeCliente = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Nome do cliente"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            isError = isNomeError,
            supportingText = {
                if (isNomeError){
                        Text(text = "O nome é obrigatorio")
                }
            },
            trailingIcon = {
                if (isNomeError){
                    Icon(imageVector = Icons.Default.Info, contentDescription = "atencao")
                }
            }
        )
        OutlinedTextField(
            value = EmailCliente,
            onValueChange = {EmailCliente = it},
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Email do cliente"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            isError = isEmailError,
            supportingText = {
                if (isEmailError){
                    Text(text = "O email é obrigatorio")
                }
            },
            trailingIcon = {
                if (isNomeError){
                    Icon(imageVector = Icons.Default.Info, contentDescription = "atencao")
                }
            }
        )
        Button(
            onClick = {
                if (validar()){
                    val cliente = cliente(
                    id = null,
                    nome = NomeCliente,
                    email = EmailCliente
                )
                    GlobalScope.launch(Dispatchers.IO) {
                        val clienteNovo = clienteApi
                            .cadastrarCliente(cliente)
                            .await()
                        mostrarMensagemSucesso = true
                        println("************************$clienteNovo")
                    }
                }
            },
            modifier =  Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text(
                text = "Gravar cliente"
            )
        }
    }
    if (mostrarMensagemSucesso){
        AlertDialog(
            onDismissRequest = {
                mostrarMensagemSucesso = false
                NomeCliente = ""
                EmailCliente = ""
            },
            title = {
                Text(text = "Sucesso")
            },
            text = {
                Text(text = "Cliente $NomeCliente gravado com sucesso!\nDeseja cadastrar outro cliente?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        NomeCliente = ""
                        EmailCliente = ""
                        mostrarMensagemSucesso = false
                    }
                ) {
                    Text(text = "sim")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        controleNavegacao!!.navigate("conteudo")
                    }
                ) {
                    Text(text = "Não")
                }
            }
        )
    }
    }
}
@Composable
@Preview
    (uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun ClienteFormPreview(){
    ClienteAppTheme {
        ClienteForm(PaddingValues(0.dp), null)
    }
}

