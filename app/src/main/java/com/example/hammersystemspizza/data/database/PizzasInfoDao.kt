package com.example.hammersystemspizza.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hammersystemspizza.data.database.model.DessertInfoModel
import com.example.hammersystemspizza.data.database.model.PizzaInfoModel


@Dao
interface PizzasInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzasInfoList(priceList: List<PizzaInfoModel>)

    @Query("select * from pizzas_list order by id asc")
    fun getPizzasListAsc(): LiveData<List<PizzaInfoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDessertInfoList(priceList: List<DessertInfoModel>)

    @Query("select * from desserts_list order by id asc")
    fun getDessertsListAsc(): LiveData<List<DessertInfoModel>>

}