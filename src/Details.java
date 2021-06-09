import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Details {
    String getFlightName();

    LocalDateTime getDeparture();

    String getDestination();

    String getFlightNumber();

    LocalDateTime getEstArrival();

    int getGateNum();


}
