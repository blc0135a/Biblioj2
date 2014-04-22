package biblioj2



import org.junit.*
import grails.test.mixin.*

@TestFor(LivreReserveController)
@Mock(LivreReserve)
class LivreReserveControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/livreReserve/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.livreReserveInstanceList.size() == 0
        assert model.livreReserveInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.livreReserveInstance != null
    }

    void testSave() {
        controller.save()

        assert model.livreReserveInstance != null
        assert view == '/livreReserve/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/livreReserve/show/1'
        assert controller.flash.message != null
        assert LivreReserve.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/livreReserve/list'

        populateValidParams(params)
        def livreReserve = new LivreReserve(params)

        assert livreReserve.save() != null

        params.id = livreReserve.id

        def model = controller.show()

        assert model.livreReserveInstance == livreReserve
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/livreReserve/list'

        populateValidParams(params)
        def livreReserve = new LivreReserve(params)

        assert livreReserve.save() != null

        params.id = livreReserve.id

        def model = controller.edit()

        assert model.livreReserveInstance == livreReserve
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/livreReserve/list'

        response.reset()

        populateValidParams(params)
        def livreReserve = new LivreReserve(params)

        assert livreReserve.save() != null

        // test invalid parameters in update
        params.id = livreReserve.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/livreReserve/edit"
        assert model.livreReserveInstance != null

        livreReserve.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/livreReserve/show/$livreReserve.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        livreReserve.clearErrors()

        populateValidParams(params)
        params.id = livreReserve.id
        params.version = -1
        controller.update()

        assert view == "/livreReserve/edit"
        assert model.livreReserveInstance != null
        assert model.livreReserveInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/livreReserve/list'

        response.reset()

        populateValidParams(params)
        def livreReserve = new LivreReserve(params)

        assert livreReserve.save() != null
        assert LivreReserve.count() == 1

        params.id = livreReserve.id

        controller.delete()

        assert LivreReserve.count() == 0
        assert LivreReserve.get(livreReserve.id) == null
        assert response.redirectedUrl == '/livreReserve/list'
    }
}
