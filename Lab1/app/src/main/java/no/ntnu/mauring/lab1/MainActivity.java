package no.ntnu.mauring.lab1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    MessageListAdapter msgAdapter;
    EditText searchField;
    ArrayList<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageList = new ArrayList<>();

        msgAdapter = new MessageListAdapter(this, messageList);

        ListView listView = (ListView) findViewById(R.id.messageListView);
        listView.setAdapter(msgAdapter);

        searchField = (EditText) findViewById(R.id.SearchTextBox);

        FloatingActionButton msgBut = (FloatingActionButton) findViewById(R.id.mainNewMessageButton);
        msgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Banana.class);
                startActivityForResult(intent, 2);
            }
        });

        ImageButton searchBut = (ImageButton) findViewById(R.id.SearchButton);
        searchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = searchField.getText().toString();
                String resultMessage = "";
                for (Message msg : messageList) {
                    if (msg.getMessage().contains(searchText)) {
                        resultMessage = msg.getUser() + ":\n" + msg.getMessage();
                    }

                }

                Intent intent = new Intent(MainActivity.this, SearchResult.class);
                intent.putExtra("RESULT", resultMessage);
                startActivity(intent);
            }
        });

        listView.invalidateViews();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            String returnMessage = data.getStringExtra("MESSAGE");

            Message newMessage = new Message(returnMessage);
            msgAdapter.add(newMessage);
        }
    }
}
