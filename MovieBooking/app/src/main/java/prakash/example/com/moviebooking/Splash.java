package prakash.example.com.moviebooking;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
     m=MediaPlayer.create(Splash.this, R.raw.music);
        m.start();

        Thread t=new Thread()
        {
            public void run(){
                try{
                 sleep(5000);
                }
                catch(InterruptedException e)
                {
                   e.printStackTrace();
                }
                finally{
                    Intent i=new Intent(Splash.this,Login.class);
                    startActivity(i);


                }
            }
        };
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        m.release();
        finish();
    }
}
