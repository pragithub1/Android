package prakash.example.com.moviebooking;

/**
 * Created by Prakash on 27-Jul-18.
 */

public class Item {
    String movie_name,movie_language,date,actor;
    int price;

    public Item(String movie_name, String movie_language, String date, String actor, int price) {
        this.movie_name = movie_name;
        this.movie_language = movie_language;
        this.date = date;
        this.actor = actor;
        this.price = price;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public String getDate() {
        return date;
    }

    public String getActor() {
        return actor;
    }

    public int getPrice() {
        return price;
    }
}
