package no.ntnu.mauring.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


public class Banana extends AppCompatActivity {

    EditText txtField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana);


        txtField = (EditText) findViewById(R.id.bananaMsgBox);

        ImageButton sendMsg = (ImageButton) findViewById(R.id.bananaSendMsg);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = txtField.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("MESSAGE", message);
                setResult(2, intent);
                finish();
            }
        });
    }
}
