package com.example.hammersystemspizza.data.mapper

import com.example.hammersystemspizza.data.database.model.PizzaInfoModel
import com.example.hammersystemspizza.data.model.PizzaInfoDto

class PizzaMapper {

    private fun pizzaInfoDtoToModel(dto: PizzaInfoDto) =
        PizzaInfoModel(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            description = dto.description,
            img = dto.img
        )

    fun listPizzaInfoDtoToModel(dto: List<PizzaInfoDto>): List<PizzaInfoModel> {
        val pizzaList: MutableList<PizzaInfoModel> = mutableListOf()
        for (pizza in dto) {
            pizzaList.add(pizzaInfoDtoToModel(pizza))
        }
        return pizzaList
    }

}