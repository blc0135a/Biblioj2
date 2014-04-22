package biblioj2

import org.springframework.dao.DataIntegrityViolationException

class LivreReserveController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [livreReserveInstanceList: LivreReserve.list(params), livreReserveInstanceTotal: LivreReserve.count()]
    }

    def create() {
        [livreReserveInstance: new LivreReserve(params)]
    }

    def save() {
        def livreReserveInstance = new LivreReserve(params)
        if (!livreReserveInstance.save(flush: true)) {
            render(view: "create", model: [livreReserveInstance: livreReserveInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), livreReserveInstance.id])
        redirect(action: "show", id: livreReserveInstance.id)
    }

    def show(Long id) {
        def livreReserveInstance = LivreReserve.get(id)
        if (!livreReserveInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "list")
            return
        }

        [livreReserveInstance: livreReserveInstance]
    }

    def edit(Long id) {
        def livreReserveInstance = LivreReserve.get(id)
        if (!livreReserveInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "list")
            return
        }

        [livreReserveInstance: livreReserveInstance]
    }

    def update(Long id, Long version) {
        def livreReserveInstance = LivreReserve.get(id)
        if (!livreReserveInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (livreReserveInstance.version > version) {
                livreReserveInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'livreReserve.label', default: 'LivreReserve')] as Object[],
                          "Another user has updated this LivreReserve while you were editing")
                render(view: "edit", model: [livreReserveInstance: livreReserveInstance])
                return
            }
        }

        livreReserveInstance.properties = params

        if (!livreReserveInstance.save(flush: true)) {
            render(view: "edit", model: [livreReserveInstance: livreReserveInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), livreReserveInstance.id])
        redirect(action: "show", id: livreReserveInstance.id)
    }

    def delete(Long id) {
        def livreReserveInstance = LivreReserve.get(id)
        if (!livreReserveInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "list")
            return
        }

        try {
            livreReserveInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'livreReserve.label', default: 'LivreReserve'), id])
            redirect(action: "show", id: id)
        }
    }
}
