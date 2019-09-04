import spock.lang.Specification

class TripDataServiceSpec extends Specification {

    private TripDataService service = new TripDataServiceImpl()

    def "buildFromFile on empty file returns empty list"() {
        given:
        def emptyFile = "src/test/resources/empty.txt"

        when:
        def output = service.buildFromFile(emptyFile)

        then:
        noExceptionThrown()
        output != null
        output instanceof List<String>
        output.size() == 0
    }
}
