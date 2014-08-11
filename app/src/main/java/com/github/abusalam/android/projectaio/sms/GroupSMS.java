package com.github.abusalam.android.projectaio.sms;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;

import com.github.abusalam.android.projectaio.R;
import com.github.abusalam.android.projectaio.ajax.Request;
import com.github.abusalam.android.projectaio.ajax.Transport;

public class GroupSMS extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_sms);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sms_groups, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        final Button GetAjaxData = (Button) findViewById(R.id.btnSendSMS);

        GetAjaxData.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // WebServer Request URL
                String serverURL = "http://10.0.2.2/apps/android/index.php";

                Request r = new Request(serverURL){

                    // Optional callback override.
                    @Override
                    protected void onSuccess(Transport transport) {
                        // Your handling code goes here,
                        // The 'transport' object holds all the desired response data.
                        Log.d("JSON: ", transport.getResponseJson().toString());
                    }
                };
                r.execute("GET");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_sm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}