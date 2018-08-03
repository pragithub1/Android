package prakash.example.com.moviebooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button login;
    TextView login1;
    String name;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Login");
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.ev_username);
        password=(EditText)findViewById(R.id.ev_password);
        login=(Button)findViewById(R.id.bv_login);
        login1=(TextView)findViewById(R.id.tv_login);
        password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
      //name=username.getText().toString();
       //pass=password.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               name=username.getText().toString();
                pass=password.getText().toString();

                if((name.equals("admin")&&pass.equals("admin"))||(name.equals("prakash")&&pass.equals("prakash")))
                {
                    Intent in=new Intent(getApplicationContext(),MovieList.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(),"You have been successfully logged in.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Ussername or Password incorrect!!! ",Toast.LENGTH_SHORT).show();
                    login1.setText("Try Again");
                     username.setText("");
            password.setText("");

                }
            }
        });

    }

}
