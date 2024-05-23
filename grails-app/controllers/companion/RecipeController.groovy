package companion

import grails.rest.RestfulController
import grails.gorm.transactions.Transactional


class RecipeController extends RestfulController {

    static allowedMethods = [addCategory: "PUT", listRecipeIngredients: "GET", removeCategory: "PUT"]

    RecipeController() {
        super(Recipe)
    }

    @Transactional
    def addCategory(){
        def data = request.JSON
        Recipe recipe = Recipe.get(params.id)
        Category category = Category.get(data.id)
        recipe.categories.add(category)
        recipe.save(flush: true, failOnError: true)
        respond category
    }

    @Transactional
    def listRecipeIngredients() {
        def data = request.JSON
        Recipe recipe = data.recipe
        respond RecipeUtil.listRecipeIngredients(recipe)
    }

    @Transactional
    def removeCategory(){
        def data = request.JSON
        Recipe recipe = Recipe.get(params.id)
        Category category = Category.get(data.id)
        recipe.categories.remove(category)
        recipe.save(flush: true, failOnError: true)
        respond recipe
    }

}