import spock.lang.Specification

class DrivingHistorySpec extends Specification {

    def "it runs without exceptions"() {
        setup:
        def args = []

        when:
        DrivingHistory.main(args as String[])

        then:
        noExceptionThrown()
    }
}
