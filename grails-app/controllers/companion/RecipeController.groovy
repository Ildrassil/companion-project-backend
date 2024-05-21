package companion

import grails.rest.RestfulController


class RecipeController extends RestfulController {
    static allowedMethods = []
    RecipeController() {
        super(Recipe)
    }

    def create() {
        def data = request.JSON
        Recipe recipe = new Recipe( data.properties)
        recipe.save(flush: true)
        respond recipe
    }
}