package companion

import companion.submodel.MeasurementUnit


class RecipeIngredient {
    Recipe recipe
    Ingredient ingredient
    String amount = '0'
    MeasurementUnit unit = MeasurementUnit.g


    static constraints = {
        ingredient blank: false
        amount blank: false
        unit blank: false
        recipe blank: false
    }
    static mapping = {
        id generator: 'sequence'
        unit enumType: 'string'
    }
}
