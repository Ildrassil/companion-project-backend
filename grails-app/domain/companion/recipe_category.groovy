package companion

class recipe_category {
    int recipe_id
    int category_id
    static mapping = {
        id composite: ['recipe_id', 'category_id']
    }
    static constraints = {
        recipe_id blank: false
        category_id blank: false
    }
}
