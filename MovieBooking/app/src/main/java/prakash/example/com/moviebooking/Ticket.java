package prakash.example.com.moviebooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Ticket extends AppCompatActivity {
    TextView mname1,cname1,date2,value;
    String name,cname,date;
    int price;
    int num,price1,num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Your Ticket");

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setContentView(R.layout.activity_ticket);
        mname1=(TextView)findViewById(R.id.tv_mname1);
        cname1=(TextView)findViewById(R.id.tv_cname1);
        date2=(TextView)findViewById(R.id.tv_date2);
        value=(TextView)findViewById(R.id.tv_value);

        Intent i=getIntent();
        name=i.getStringExtra("name");
        cname=i.getStringExtra("cname1");
        date=i.getStringExtra("date");
        price=i.getIntExtra("price",0);
        num=i.getIntExtra("num",0);

       //price1= Integer.parseInt(price);
        num1=price*num;


        mname1.setText("Movie: "+name);
        cname1.setText("Customer Name: "+cname);
        date2.setText("Date On: "+date);
        value.setText(" ₹"+String.valueOf(num1));



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
