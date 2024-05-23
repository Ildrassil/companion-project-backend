package companion

import companion.submodel.MeasurementUnit


class RecipeIngredient {
    Recipe recipe
    Ingredient ingredient
    String name
    String amount = '0'
    MeasurementUnit unit = MeasurementUnit.g


    static constraints = {
        ingredient blank: false
        amount blank: false
        unit blank: false
        recipe blank: false
        name nullable: true
    }
    static mapping = {
        id generator: 'sequence'
        unit enumType: 'string'
    }
    def beforeInsert() {
        this.name = this.ingredient?.name
    }
}
