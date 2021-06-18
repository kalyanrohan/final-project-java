import java.time.LocalDateTime;

//interface for classes such as ticket and airline which inherits the same set of functions
public interface Details {
    String getFlightName();

    LocalDateTime getDeparture();

    String getDestination();

    String getFlightNumber();

    LocalDateTime getEstArrival();

    int getGateNum();


}
