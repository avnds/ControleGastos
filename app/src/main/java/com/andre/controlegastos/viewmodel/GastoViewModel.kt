package com.andre.controlegastos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.andre.controlegastos.data.AppDatabase
import com.andre.controlegastos.data.Gasto
import com.andre.controlegastos.data.GastoRepository
import kotlinx.coroutines.launch

class GastoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GastoRepository(
        AppDatabase.getDatabase(application).gastoDao()
    )

    val gastos = repository.gastos

    fun adicionarGasto(
        descricao: String,
        valor: Double,
        categoria: String
    ) {
        val gasto = Gasto(
            descricao = descricao,
            valor = valor,
            categoria = categoria
        )

        viewModelScope.launch {
            repository.inserir(gasto)
        }
    }

    fun excluirGasto(gasto: Gasto) {
        viewModelScope.launch {
            repository.excluir(gasto)
        }
    }
}