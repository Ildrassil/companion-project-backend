package companion

import grails.rest.RestfulController

class RecipeIngredientController extends RestfulController {


    RecipeIngredientController() {
        super(RecipeIngredient)
    }

    def listRecipeIngredients(Recipe recipe) {
        respond RecipeIngredient.where {
            recipe == recipe
        }.list()
    }


}

