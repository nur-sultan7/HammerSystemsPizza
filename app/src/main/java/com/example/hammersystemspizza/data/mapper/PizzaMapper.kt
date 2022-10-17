package com.example.hammersystemspizza.data.mapper

import com.example.hammersystemspizza.data.database.model.DessertInfoModel
import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.data.network.model.DessertInfoDto
import com.example.hammersystemspizza.data.network.model.PizzaInfoDto
import com.example.hammersystemspizza.domain.entities.CategoryName
import com.example.hammersystemspizza.domain.entities.ItemInfo

class PizzaMapper {


    private fun pizzaInfoDtoToModel(dto: PizzaInfoDto): PizzaInfoModel =
        PizzaInfoModel(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            description = dto.description,
            img = dto.img
        )

    private fun dessertInfoDtoToModel(dto: DessertInfoDto): DessertInfoModel =
        DessertInfoModel(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            description = dto.description,
            img = dto.img
        )


    fun pizzaInfoModelToEntity(model: PizzaInfoModel) =
        ItemInfo(
            id = model.id,
            name = model.name,
            price = model.price,
            description = model.description,
            img = model.img,
            type = CategoryName.Pizza
        )

    fun dessertInfoModelToEntity(model: DessertInfoModel) =
        ItemInfo(
            id = model.id,
            name = model.name,
            price = model.price,
            description = model.description,
            img = model.img,
            type = CategoryName.Dessert
        )

    fun listPizzaInfoDtoToModel(dto: List<PizzaInfoDto>): List<PizzaInfoModel> {
        val pizzaList: MutableList<PizzaInfoModel> = mutableListOf()
        for (pizza in dto) {
            pizzaList.add(pizzaInfoDtoToModel(pizza))
        }
        return pizzaList
    }

    fun listDessertInfoDtoToModel(dto: List<DessertInfoDto>): List<DessertInfoModel> {
        val dessertList: MutableList<DessertInfoModel> = mutableListOf()
        for (dessert in dto) {
            dessertList.add(dessertInfoDtoToModel(dessert))
        }
        return dessertList
    }

}