package companion

import grails.rest.RestfulController
import grails.gorm.transactions.Transactional


class RecipeController extends RestfulController {

    static allowedMethods = [addCategory: "PUT", listRecipeIngredients: "GET"];

    RecipeController() {
        super(Recipe)
    }

    @Transactional
    def addCategory() {
        def data = request.JSON
        Recipe recipe = data.recipe
        Category category = data.category
        recipe.addToCategories(category)
        category.addToRecipes(recipe)
        recipe.save(flush: true)
        category.save(flush: true)
        respond recipe
    }

    @Transactional
    def listRecipeIngredients() {
        def data = request.JSON
        Recipe recipe = data.recipe
        respond RecipeUtil.listRecipeIngredients(recipe)
    }

}