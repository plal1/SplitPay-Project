package com.cs442.project.splitpay;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registration extends ActionBarActivity {

    String name;
    String email;
    int phone;
    String uname;
    String passwd;
    String conpass;
    String card;
    String ctype;
    String cname;
    int cnum;
    Date exp;
    int cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.drawable.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void register (View view)
    {
        EditText fullname = (EditText)findViewById(R.id.name);
        EditText email_id = (EditText)findViewById(R.id.email);
        EditText phone_no = (EditText)findViewById(R.id.phone);
        EditText username = (EditText)findViewById(R.id.uname);
        EditText password = (EditText)findViewById(R.id.passwd);
        EditText repassword = (EditText)findViewById(R.id.conpass);

        EditText card_name = (EditText)findViewById(R.id.cname);
        EditText card_num = (EditText)findViewById(R.id.cnum);
        EditText card_date = (EditText)findViewById(R.id.date_in);
        EditText card_cvv = (EditText)findViewById(R.id.cvv_in);

        String fname = fullname.getText().toString();
        String mail = email_id.getText().toString();
        int pno = Integer.parseInt(phone_no.getText().toString());
        String user_name = username.getText().toString();
        String pass = password.getText().toString();
        String confirm = repassword.getText().toString();

        String cardname = card_name.getText().toString();
        int cardnum = Integer.parseInt(card_num.getText().toString());

        int c_cvv = Integer.parseInt(card_cvv.getText().toString());

        Toast.makeText(this, "Hi: " + fname, Toast.LENGTH_LONG).show();
    }

    public void Cancel(View view)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
