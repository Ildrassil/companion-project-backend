package companion

import companion.submodel.MeasurementUnit


class RecipeIngredient {
    String id
    Ingredient ingredient
    String amount
    MeasurementUnit measurementUnit

    static constraints = {
        ingredient blank: false
        amount blank: false
        measurementUnit blank: false
    }
    static mapping = {
        id generator: 'sequence'
    }
}
