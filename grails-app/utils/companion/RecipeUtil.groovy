package companion


import companion.submodel.MainCategory

class RecipeUtil {

    public static List<RecipeIngredient> listRecipeIngredients(Recipe recipe) {
        return RecipeIngredient.where {
            recipe == recipe
        }.list()
    }

    public static MainCategory determineMainCategory(RecipeIngredient[] recipeIngredients ) {
        if (recipeIngredients.size() == 0) {
            return MainCategory.REGULAR
        } else {
            int countVegetarian = 0
            int countVegan = 0
            for (recipeIngredient in recipeIngredients) {
                if (recipeIngredient.ingredient.mainCategory == MainCategory.REGULAR) {
                    return MainCategory.REGULAR
                }
                if (recipeIngredient.ingredient.mainCategory == MainCategory.VEGETARIAN) {
                    countVegetarian++
                }
                if (recipeIngredient.ingredient.mainCategory == MainCategory.VEGAN) {
                    countVegan++
                }
            }
            if (countVegetarian > 0) {
                return MainCategory.VEGETARIAN
            } else {
                return MainCategory.VEGAN
            }

        }
    }
}
