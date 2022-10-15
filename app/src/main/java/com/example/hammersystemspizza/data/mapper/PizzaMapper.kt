package com.example.hammersystemspizza.data.mapper

import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.data.model.PizzaInfoDto
import com.example.hammersystemspizza.domain.entities.PizzaInfo

class PizzaMapper {


    fun pizzaInfoDtoToModel(dto: PizzaInfoDto): PizzaInfoModel =
        PizzaInfoModel(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            description = dto.description,
            img = dto.img
        )

    fun pizzaInfoModelToEntity(model: PizzaInfoModel) =
        PizzaInfo(
            id = model.id,
            name = model.name,
            price = model.price,
            description = model.description,
            img = model.img
        )

    fun listPizzaInfoDtoToModel(dto: List<PizzaInfoDto>): List<PizzaInfoModel> {
        val pizzaList: MutableList<PizzaInfoModel> = mutableListOf()
        for (pizza in dto) {
            pizzaList.add(pizzaInfoDtoToModel(pizza))
        }
        return pizzaList
    }

}