package companion

import companion.submodel.MainCategory

class Ingredient {
    String name
    MainCategory mainCategory
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false
        mainCategory blank: false
    }
    static mapping = {
        id generator: 'sequence'
    }
}
