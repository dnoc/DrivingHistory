import spock.lang.Specification

import java.time.LocalTime

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
        output instanceof List<Driver>
        output.size() == 0
    }

    def "buildFromFile returns list of drivers with trips :: standard input"() {
        given:
        def standardInput = "src/test/resources/standard.txt"
        def danTripList = [
                new Trip(LocalTime.parse("07:15"), LocalTime.parse("07:45"), 17.3f),
                new Trip(LocalTime.parse("06:12"), LocalTime.parse("06:32"), 21.8f)
        ]
        def dan = new Driver("Dan", danTripList)
        def alexTripList = [ new Trip(LocalTime.parse("12:01"), LocalTime.parse("13:16"), 42.0f) ]
        def alex = new Driver("Alex", alexTripList)
        def bob = new Driver("Bob")

        when:
        def output = service.buildFromFile(standardInput)

        then:
        noExceptionThrown()
        output != null
        output instanceof List<Driver>
        output.size() == 3
        output.any { it.name == dan.name && it.trips.size() == dan.trips.size() }
        output.any { it.name == alex.name && it.trips.size() == alex.trips.size() }
        output.any { it.name == bob.name && bob.trips.empty }
    }

    def "buildFromFile returns list of drivers with trips :: no trips"() {
        given:
        def standardInput = "src/test/resources/no_trips.txt"
        List<Trip> emptyTripList = []

        when:
        def output = service.buildFromFile(standardInput)

        then:
        noExceptionThrown()
        output != null
        output instanceof List<Driver>
        output.size() == 8
        output.any { it.name == "Dan" && it.trips == emptyTripList }
        output.any { it.name == "Alex" && it.trips == emptyTripList }
        output.any { it.name == "Bob" && it.trips == emptyTripList }
        output.any { it.name == "Rachel" && it.trips == emptyTripList }
        output.any { it.name == "Susan" && it.trips == emptyTripList }
        output.any { it.name == "Cody" && it.trips == emptyTripList }
        output.any { it.name == "Xi" && it.trips == emptyTripList }
        output.any { it.name == "Bridget" && it.trips == emptyTripList }
    }

    def "buildFromFile returns list of drivers with trips :: missing driver"() {
        given:
        def standardInput = "src/test/resources/standard.txt"
        def danTripList = [
                new Trip(LocalTime.parse("07:15"), LocalTime.parse("07:45"), 17.3f),
                new Trip(LocalTime.parse("06:12"), LocalTime.parse("06:32"), 21.8f)
        ]
        def dan = new Driver("Dan", danTripList)
        def alexTripList = [ new Trip(LocalTime.parse("12:01"), LocalTime.parse("13:16"), 42.0f) ]
        def alex = new Driver("Alex", alexTripList)
        def bob = new Driver("Bob")

        when:
        def output = service.buildFromFile(standardInput)

        then:
        noExceptionThrown()
        output != null
        output instanceof List<Driver>
        output.size() == 3
        output.any { it.name == dan.name && it.trips.size() == dan.trips.size() }
        output.any { it.name == alex.name && it.trips.size() == alex.trips.size() }
        output.any { it.name == bob.name && bob.trips.empty }
        output.any { it.name == bob.name && bob.trips.empty }
        !output.any { it.name == "Sally" }
    }
}
