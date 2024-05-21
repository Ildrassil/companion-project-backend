package companion

import companion.submodel.MainCategory



class Recipe {
    String name
    String shortDescription
    String description
    MainCategory mainCategory
    Date dateCreated
    Date lastUpdated

    static hasMany = [categories: Category]

    static constraints = {
        lastUpdated nullable: true
        name blank: false
        shortDescription blank: false
        description blank: false
        mainCategory blank: true
    }
    static mapping = {
        id generator: 'sequence'
        description type: 'text'
        shortDescription type: 'text'
    }

}
