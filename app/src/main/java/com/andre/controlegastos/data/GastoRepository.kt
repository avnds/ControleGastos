package com.andre.controlegastos.data

class GastoRepository(
    private val gastoDao: GastoDao
) {

    val gastos = gastoDao.listarGastos()

    suspend fun inserir(gasto: Gasto) {
        gastoDao.inserirGasto(gasto)
    }

    suspend fun excluir(gasto: Gasto) {
        gastoDao.excluirGasto(gasto)
    }
}