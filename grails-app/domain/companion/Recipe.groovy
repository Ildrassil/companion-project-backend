package companion

import companion.submodel.MainCategory


class Recipe {
    String id
    String name
    String shortDescription
    String description
    RecipeIngredient[] recipeIngredients
    Category[] categories
    MainCategory mainCategory
    Date dateCreated
    Date lastUpdated

    static hasMany = [recipeIngredients: RecipeIngredient, categories: Category]

    static constraints = {
        lastUpdated nullable: true
        name blank: false
        shortDescription blank: false
        description blank: false
    }
    static mapping = {
        id generator: 'sequence'
        description type: 'text'
        shortDescription type: 'text'
    }
}
