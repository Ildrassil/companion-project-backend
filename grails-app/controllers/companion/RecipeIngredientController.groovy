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
        Recipe recipe = data.recipe
        Ingredient ingredient = data.ingredient
        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe: recipe, ingredient: ingredient)
        recipeIngredient.save(flush: true)
        respond recipeIngredient
    }

    @Transactional
    def listRecipeIngredients() {
        def data = request.JSON
        Recipe recipe = data.properties
        respond RecipeUtil.listRecipeIngredients(recipe)
    }

    @Transactional
    def update() {
        def data = request.JSON
        RecipeIngredient recipeIngredient = data.recipeIngredient
        RecipeIngredient recipeIngredientInstance = RecipeIngredient.get(params.id)
        recipeIngredientInstance.amount = recipeIngredient.amount
        recipeIngredientInstance.unit = recipeIngredient.unit
        respond recipeIngredientInstance.save(flush: true)
    }


}

