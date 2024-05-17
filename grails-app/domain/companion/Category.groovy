package companion


class Category {

    String id
    String name
    String description
    Date dateCreated
    Date lastUpdated
    static mapping = {
        id generator: 'sequence'
        description type: 'text'
    }
    static constraints = {
        lastUpdated nullable: true
        name blank: false
        description blank: false
    }

}
