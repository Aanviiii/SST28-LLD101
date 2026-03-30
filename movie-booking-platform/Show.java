import java.util.*;

class Show {
    String showId;
    Movie movie;
    Screen screen;
    Date startTime;

    Map<String, ShowSeat> showSeats = new HashMap<>();

    public Show(String showId, Movie movie, Screen screen) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
    }

    public String getShowId() {
        return showId;
    }

    public Collection<ShowSeat> getAllSeats() {
        return showSeats.values();
    }
}