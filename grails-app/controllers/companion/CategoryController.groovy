package companion.project.backend

class CategoryController {

    def create() {
        Category category = new Category()
        category.name = 'Hello World'
        category.description = 'This is a test'
        Category.save(failOnError: true)
    }

    def index(){

    }

    def delete() {

    }

    def update() {

    }

    def show() {

    }

    def showAll() {

    }
}
