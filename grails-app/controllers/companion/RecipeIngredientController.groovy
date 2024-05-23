package companion

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

class RecipeIngredientController extends RestfulController {

    static allowedMethods = [create: "POST", listRecipeIngredients: "GET", update: "PUT"]

    RecipeIngredientController() {
        super(RecipeIngredient)
    }

    @Transactional
    def create() {
        def data = request.JSON
        Recipe recipe = Recipe.get(data.recipe.id)
        Ingredient ingredient = Ingredient.get(data.ingredient.id)
        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe: recipe, ingredient: ingredient)
        recipeIngredient.save(flush: true)
        respond recipeIngredient
    }


    def listRecipeIngredients() {
        Recipe recipe = Recipe.get(params.id)
        respond RecipeUtil.listRecipeIngredients(recipe)
    }

    @Transactional
    def update() {
        def data = request.JSON
        RecipeIngredient recipeIngredientInstance = RecipeIngredient.get(params.id)
        recipeIngredientInstance.amount = data.amount
        recipeIngredientInstance.unit = data.unit
        respond recipeIngredientInstance.save(flush: true)
    }


}

