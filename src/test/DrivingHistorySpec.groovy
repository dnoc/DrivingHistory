import spock.lang.Specification

class DrivingHistorySpec extends Specification {

    def "it runs without exceptions"() {
        setup:
        def filename = "src/test/resources/empty.txt"
        def args = [filename]

        when:
        DrivingHistory.main(args as String[])

        then:
        noExceptionThrown()
    }
}
