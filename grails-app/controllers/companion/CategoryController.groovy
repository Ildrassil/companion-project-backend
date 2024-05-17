package companion

import grails.gorm.transactions.Transactional
import org.springframework.http.HttpStatus

class CategoryController {
    static allowedMethods = [index: 'GET', create: 'POST', save: 'POST', update: 'PUT', delete: 'DELETE']
    // POST
    @Transactional
    def create() {
        def data = request.JSON
        if(!data.name || !data.description) {
            render status: HttpStatus.PRECONDITION_FAILED
            return
        }
        Category category = new Category()
        category.name = data.name
        category.description = data.description
        Category.save(failOnError: true)
        respond(category, status: HttpStatus.CREATED)
    }
    // GET
    def index(){
        respond Category.list()
    }
    // DELETE
    @Transactional
    def delete() {
        Category category = Category.get(params.id)
        category.delete()
        render status: HttpStatus.NO_CONTENT
    }
    // PUT
    @Transactional
    def update() {

    }
    // GET
    def show() {

    }

}
