package no.ntnu.mauring.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.design.widget.Snackbar;



public class Banana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana);

        final Intent intent = new Intent(this, MainActivity.class);

        final EditText txtField = (EditText) findViewById(R.id.bananaMsgBox);

        ImageButton sendMsg = (ImageButton) findViewById(R.id.bananaSendMsg);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("EditText", txtField.getText().toString());
                intent.putExtra("msg", txtField.getText());
                finish();
            }
        });
    }
}
