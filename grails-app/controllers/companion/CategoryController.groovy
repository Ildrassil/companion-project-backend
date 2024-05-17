package companion

import grails.gorm.transactions.Transactional
import org.springframework.http.HttpStatus

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime

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
        category.properties = datanow()
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
        def data = request.JSON
        Category category = Category.get(params.id)
        category.properties = data
        category.save(failOnError: true)
        respond category

    }
    // GET
    def show() {
        Category category = Category.get(params.id)
        respond category

    }

}
