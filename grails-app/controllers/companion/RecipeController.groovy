package companion

import grails.rest.RestfulController


class RecipeController extends RestfulController {

    static allowedMethods = [addCategory: "PUT"]

    RecipeController() {
        super(Recipe)
    }


    def addCategory(Recipe recipe, Category category) {
        recipe.addToCategories(category)
        category.addToRecipes(recipe)
        recipe.save(flush: true)
        category.save(flush: true)
        respond recipe
    }

}