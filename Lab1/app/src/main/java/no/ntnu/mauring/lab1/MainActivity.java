package no.ntnu.mauring.lab1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.messageListView);

        final Intent createMsg = new Intent(MainActivity.this, Banana.class);

        String recMsg = "Placeholder";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            recMsg = extras.getString("msg");
        }

        List<Message> data = Arrays.asList(
                new Message("TestMessage"),
                new Message(recMsg),
                new Message("TestMessage", "Papoy"),
                new Message("TestMessage", "Minion #33")
        );

        //data.add(new Message(recMsg)); Unable to add, recieve crash from virtual test environment..
        //Seems to be because it is not an arraylist, however I have been unsuccessful in implementing an working solution,
        //therefore there is an temporary placeholder to demonstrate remaining functionality.

        MessageListAdapter msgadapt = new MessageListAdapter(getApplicationContext(), data);
        ListView listView = (ListView) findViewById(R.id.messageListView);


        listView.setAdapter(msgadapt);


        FloatingActionButton msgBut = (FloatingActionButton) findViewById(R.id.mainNewMessageButton);
        msgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(createMsg);
            }
        });

        listView.invalidateViews();
    }
}
