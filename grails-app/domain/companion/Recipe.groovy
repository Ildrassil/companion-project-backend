package companion

import companion.submodel.MainCategory



class Recipe {
    String name = "New Recipe"
    String shortDescription
    String description
    MainCategory mainCategory
    Date dateCreated
    Date lastUpdated

    static hasMany = [categories: Category]

    static constraints = {
        lastUpdated nullable: true
        shortDescription nullable: true
        description nullable: true
        mainCategory nullable: true
    }
    static mapping = {
        id generator: 'sequence'
        description type: 'text'
        shortDescription type: 'text'
        mainCategory enumType: 'string'
    }
    def beforeUpdate(){
        this.mainCategory = RecipeUtil.determineMainCategory(RecipeUtil.listRecipeIngredients(this))
    }

}
