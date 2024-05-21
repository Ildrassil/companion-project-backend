package companion

import companion.submodel.MainCategory
import companion.submodel.MeasurementUnit

class RecipeService {

    def determineMainCategory(RecipeIngredient[] recipeIngredients ){
        int countVegetarian = 0
        int countVegan = 0
        for(recipeIngredient in recipeIngredients){
            if(recipeIngredient.ingredient.mainCategory == MainCategory.REGULAR){
                return MainCategory.REGULAR
            }
            if(recipeIngredient.ingredient.mainCategory == MainCategory.VEGETARIAN) {
                countVegetarian++
            }
            if (recipeIngredient.ingredient.mainCategory == MainCategory.VEGAN){
                countVegan++
            }
        }
        if(countVegetarian > 0){
            return MainCategory.VEGETARIAN
        }else {
            return MainCategory.VEGAN
        }

    }

    def addRecipeIngredient(Recipe recipe, Ingredient ingredient, String amount, MeasurementUnit unit){
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient: ingredient, amount: amount, unit: unit)
        recipe.addToRecipeIngredients(recipeIngredient)
        recipe.save(flush: true)
        return recipe
    }
}
