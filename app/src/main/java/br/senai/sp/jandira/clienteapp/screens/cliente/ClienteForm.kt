package br.senai.sp.jandira.clienteapp.screens.cliente

import android.content.res.Configuration
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.clienteapp.ui.theme.ClienteAppTheme

@Composable
fun ClienteForm(padding: PaddingValues) {

    var NomeCliente by remember { mutableStateOf("") }
    var EmailCliente by remember { mutableStateOf("") }


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
                capitalization = K
            )
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
            }
        )
        Button(
            onClick = {},
            modifier =  Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text(
                text = "Gravar cliente"
            )
        }
    } }
}
@Composable
@Preview
    (uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun ClienteFormPreview(){
    ClienteAppTheme {
        ClienteForm(PaddingValues(0.dp))
    }
}

