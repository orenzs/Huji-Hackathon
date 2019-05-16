package huji.hostia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class Login extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide(); //hide the title bar
        View v = findViewById(R.id.button2);
        v.setOnClickListener(this);
        View v2 = findViewById(R.id.button3);
        v2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button2) {
            Intent myIntent = new Intent(Login.this, UsersLogin.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
        }
        else {
            Intent myIntent = new Intent(Login.this, DonorsLogin.class);
            Log.d("start", ".\n\nMessage(String text)\n\n." + "suh");
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
        }
    }
}