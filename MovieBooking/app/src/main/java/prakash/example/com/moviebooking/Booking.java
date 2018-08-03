package prakash.example.com.moviebooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends AppCompatActivity implements View.OnClickListener {
    TextView date1,mname;
    EditText num,cname;
    Button confirm;
    String d,n;
    int p;
    String pname;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Booking");

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setContentView(R.layout.activity_booking);
        date1=(TextView)findViewById(R.id.tv_date1);
        num=(EditText)findViewById(R.id.ev_num);
        cname=(EditText)findViewById(R.id.ev_cname);
        confirm=(Button)findViewById(R.id.bv_confirm);
        mname=(TextView)findViewById(R.id.tv_mname);

       /* pname=cname.getText().toString();
        String a=num.getText().toString();
        number=new Integer(a).intValue();*/

        Intent i=getIntent();
        d=i.getStringExtra("date");
        n=i.getStringExtra("name");
        p=i.getIntExtra("price",0);
        date1.setText("Date:"+d);
        mname.setText(n);

        confirm.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        pname=cname.getText().toString();
        String a=num.getText().toString();
        try {
            number = new Integer(a).intValue();
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(getApplicationContext(),"Please Enter Number of Seats!",Toast.LENGTH_SHORT).show();
        }
        if (number<1 && pname.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Enter Name and Number of Seats!!",Toast.LENGTH_SHORT).show();
        }
       else if(pname.equals("") )
        {
            Toast.makeText(getApplicationContext(),"Please Enter Name!",Toast.LENGTH_SHORT).show();
        }
        else if (number<1)
        {
            Toast.makeText(getApplicationContext(),"Sorry, you should choose atleast one Seat!",Toast.LENGTH_SHORT).show();
        }

        else {
            Intent in = new Intent(Booking.this, Ticket.class);
            in.putExtra("date", d);
            in.putExtra("name", n);
            in.putExtra("price", p);
            in.putExtra("num", number);
            in.putExtra("cname1", pname);
            startActivity(in);
        }
    }
}
