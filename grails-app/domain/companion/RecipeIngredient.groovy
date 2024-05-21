package companion

import companion.submodel.MeasurementUnit


class RecipeIngredient {
    Recipe recipe
    Ingredient ingredient
    String amount
    MeasurementUnit unit


    static constraints = {
        ingredient blank: false
        amount blank: false
        unit blank: false
    }
    static mapping = {
        id generator: 'sequence'
    }
}
