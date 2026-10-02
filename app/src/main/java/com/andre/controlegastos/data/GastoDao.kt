package com.andre.controlegastos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {

    @Query("SELECT * FROM gastos ORDER BY id DESC")
    fun listarGastos(): Flow<List<Gasto>>

    @Insert
    suspend fun inserirGasto(gasto: Gasto)

    @Delete
    suspend fun excluirGasto(gasto: Gasto)
}