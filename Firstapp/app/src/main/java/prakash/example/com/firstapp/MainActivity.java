package prakash.example.com.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView name,count;
    ImageView img;
    EditText text;
    Button btn,btn1;
    int temp=0;
    int[] images= new int[]{
            R.drawable.ab
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.tv_name);
        img =(ImageView) findViewById(R.id.iv_image);
        text = (EditText) findViewById(R.id.ev_edit);
        btn = (Button) findViewById(R.id.bv_but);
        btn1 = (Button) findViewById(R.id.bv_but1);
        count= (TextView)findViewById(R.id.tv_count);

        name.setText("Name Changed");
        img.setImageResource(R.drawable.ab);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setText("Button2 Clicked for: "+ ++temp);
            }

        });
    }

    public void buttonclick(View view) {

        Toast.makeText(getApplicationContext(),"button1 pressed",Toast.LENGTH_SHORT).show();
        String mes=text.getText().toString();
        name.setText(mes);

    }
}
