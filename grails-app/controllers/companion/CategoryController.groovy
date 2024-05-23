package companion

import grails.rest.RestfulController

import grails.gorm.transactions.Transactional

class CategoryController extends RestfulController {

    static allowedMethods = [add: "POST", addRecipe: "PUT"]

    CategoryController(){
        super(Category)
    }
    @Transactional
    def add() {
        def data = request.JSON
        Category category = new Category(name: data.name, description: data.description)
        category.save(flush: true)
        respond category
    }

    @Transactional
    def addRecipe() {
        def data = request.JSON
        Recipe recipe = data.recipe
        Category category = Category.get(params.id)
        category.addToRecipes(recipe)
        recipe.addToCategories(category)
        category.save(flush: true)
        recipe.save(flush: true)
        respond category
    }

}
