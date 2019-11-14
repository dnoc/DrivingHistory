import spock.lang.Specification

import java.time.LocalTime

class TripServiceSpec extends Specification {

    TripService service = new TripServiceImpl()

    def "getAverageSpeed - Standard driver speed"() {
        given:
        def expectedAvgSpeed = 47
        def tripList = [
                new Trip(LocalTime.parse("07:15"), LocalTime.parse("07:45"), 17.3f),
                new Trip(LocalTime.parse("06:12"), LocalTime.parse("06:32"), 21.8f)
        ]

        when:
        def avgSpeed = service.getAverageSpeed(tripList)

        then:
        noExceptionThrown()
        expectedAvgSpeed == avgSpeed
    }

    def "getPercentageOfHighwayMiles - 56% highway miles"() {
        given:
        def expected = 56
        def tripList = [
                new Trip(LocalTime.parse("07:15"), LocalTime.parse("07:45"), 17.3f),
                new Trip(LocalTime.parse("06:12"), LocalTime.parse("06:32"), 21.8f)
        ]

        when:
        def highwayMilePercentage = service.getPercentageOfHighwayMiles(tripList)

        then:
        noExceptionThrown()
        expected == highwayMilePercentage
    }

    def "getInvalidTrips - 2 invalid trips"() {
        given:
        def expectedInvalid = 2
        def tripList = [
                new Trip(LocalTime.parse("12:01"), LocalTime.parse("13:16"), 42.0f),
                new Trip(LocalTime.parse("13:00"), LocalTime.parse("14:00"), 101.0f),
                new Trip(LocalTime.parse("14:00"), LocalTime.parse("15:00"), 4.0f)
        ]

        when:
        def invalidTrips = service.getInvalidTrips(tripList).size()


        then:
        expectedInvalid == invalidTrips
    }
}
