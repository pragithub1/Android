package prakash.example.com.moviebooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity implements View.OnClickListener {
    ImageView detail_image;
    TextView detail_name,detail_date,detail_language,detail_actor,detail_price;
    Button detail_book;
    int image;
    String n,d,l,a;
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("MovieDetail");

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.activity_detail);
        detail_image=(ImageView)findViewById(R.id.iv_detail_image);
        detail_name=(TextView)findViewById(R.id.tv_detail_name);
        detail_date=(TextView)findViewById(R.id.tv_detail_date);
        detail_language=(TextView)findViewById(R.id.tv_detail_language);
        detail_actor=(TextView)findViewById(R.id.tv_detail_actor);
        detail_price=(TextView)findViewById(R.id.tv_detail_price);
        detail_book=(Button)findViewById(R.id.bv_detail_book);

        Bundle b=getIntent().getExtras();
        image=b.getInt("image");
        detail_image.setImageResource(image);

        Intent i=getIntent();
        n=i.getStringExtra("name");
        d=i.getStringExtra("date");
        l=i.getStringExtra("language");
        a=i.getStringExtra("actor");
        p=i.getIntExtra("price",0);

        detail_name.setText("Name: "+n);
        detail_date.setText("Realeasing on: "+d);
        detail_language.setText("Language: "+l);
        detail_actor.setText("Actors: "+a);
        detail_price.setText("Price: ₹"+String.valueOf(p));




        detail_book.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent in=new Intent(Detail.this,Booking.class);
        in.putExtra("date",d);
        in.putExtra("name",n);
        in.putExtra("price",p);
        startActivity(in);

    }
}
