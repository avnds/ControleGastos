package com.andre.controlegastos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andre.controlegastos.data.Gasto
import com.andre.controlegastos.viewmodel.GastoViewModel
import java.text.NumberFormat
import java.util.Locale
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ListaGastosScreen(
    viewModel: GastoViewModel,
    onAdicionarClick: () -> Unit
) {
    val gastos by viewModel.gastos.collectAsState(initial = emptyList())

    val total = gastos.sumOf { it.valor }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Controle de Gastos")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Total: ${formatarMoeda(total)}",
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = onAdicionarClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "+ Adicionar gasto",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(gastos) { gasto ->

                    GastoItem(
                        gasto = gasto,
                        onExcluir = {
                            viewModel.excluirGasto(gasto)
                        }
                    )
                }
            }
        }
    }
}

fun formatarMoeda(valor: Double): String {
    val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formato.format(valor)
}

@Composable

fun GastoItem(
    gasto: Gasto,
    onExcluir: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = gasto.descricao,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = gasto.categoria,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = formatarMoeda(gasto.valor),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 8.dp)
            )

            Button(
                onClick = onExcluir,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Excluir")
            }
        }
    }
}