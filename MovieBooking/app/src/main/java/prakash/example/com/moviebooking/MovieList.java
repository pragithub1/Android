package prakash.example.com.moviebooking;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.*;
import java.util.List;

public class MovieList extends AppCompatActivity {
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        getSupportActionBar().setTitle("MovieList");

        list=new ArrayList<>();
        list.add(new Item("PreemGheet","Nepali","1st janaury","Pradip and Pooja",500));
        list.add(new Item("Avatar","English","1st Fabraury","Sam and Joe",250));
        list.add(new Item("Ek-Deewana-Tha","Hindi","1st March","Vikram and Shivani",300));
        list.add(new Item("Hero","Talegu","1st April","Nikkhil and Monisha",400));
        list.add(new Item("Hobbit","English","1st May","Martin and Ian ",350));
        list.add(new Item("Hostel","Nepali","1st June","Anmol and Prakreeti",400));
        list.add(new Item("HouseFull-3","Hindi","1st July","Akashya and Jacqueline",450));
        list.add(new Item("LimitLess","English","1st August","Bradley and Jennifer",300));
        list.add(new Item("Raees","Hindi","1st September","Sharuk and Mahira",250));
        list.add(new Item("SPY","English","1st Octuber","Jason and Rose",300));

        RecyclerView rv=(RecyclerView)findViewById(R.id.rv_view);
        MovielistAdapter a=new MovielistAdapter(this,list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(a);
    }
}
