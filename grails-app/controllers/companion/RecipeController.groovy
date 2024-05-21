package companion

import companion.submodel.MainCategory
import companion.submodel.MeasurementUnit
import grails.rest.RestfulController


class RecipeController extends RestfulController {

    RecipeController() {
        super(Recipe)
    }

    def addRecipeIngredient() {
        def data = request.JSON
        Recipe recipe = Recipe.get(params.id)
        Ingredient ingredient = Ingredient.get(data.ingredientId)
        String amount = data.amount
        MeasurementUnit unit = data.unit
        RecipeService recipeService = new RecipeService()
        respond recipeService.addRecipeIngredient(recipe, ingredient, amount, unit)
    }

    def addCategory() {
        def data = request.JSON
        Recipe recipe = Recipe.get(params.id)
        Category category = Category.get(data.categoryId)
        recipe.addToCategories(category)
        recipe.save(flush: true)
        respond recipe
    }

    def create() {
        def data = request.JSON
        Recipe recipe = new Recipe( data.properties)
        recipe.mainCategory = RecipeService.determineMainCategory(recipe.recipeIngredients)
        recipe.save(flush: true)
        respond recipe
    }
}