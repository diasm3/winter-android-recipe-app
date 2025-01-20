package com.surivalcoding.composerecipeapp.data.recipe.data_source

import ApiClient
import IngredientDataSource
import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientDto
import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientModel
import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientResponseDto
import com.surivalcoding.composerecipeapp.data.recipe.ingrident.toModels
import format
import io.ktor.client.HttpClient

class IngredientDataSourceImpl(
    private val httpClient: HttpClient = ApiClient().create()
) : IngredientDataSource {
    override suspend fun getIngredients(): List<IngredientModel> {
        val ingredientData = """
           { "ingredients": [ { "id": 1, "name": "Tomatos", "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg" }, { "id": 2, "name": "Beef", "image": "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png" }, { "id": 3, "name": "Pork", "image": "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg" }, { "id": 4, "name": "Rice", "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg" }, { "id": 5, "name": "Avocado", "image": "https://cdn.pixabay.com/photo/2020/01/02/01/43/avocado-4734786_1280.jpg" }, { "id": 6, "name": "Chicken", "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg" }, { "id": 7, "name": "Sugar", "image": "https://cdn.pixabay.com/photo/2014/11/28/19/10/lump-sugar-549096_1280.jpg" }, { "id": 8, "name": "Pepper", "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg" }, { "id": 9, "name": "Onion", "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg" } ] }
  """.trimIndent()
        return format.decodeFromString<IngredientResponseDto>(ingredientData).ingredients.toModels()
    }

}