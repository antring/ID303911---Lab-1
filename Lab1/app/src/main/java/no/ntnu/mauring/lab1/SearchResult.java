package no.ntnu.mauring.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AppCompatActivity {

    MessageListAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ArrayList<Message> resultList = new ArrayList<>();

        resultAdapter = new MessageListAdapter(this, resultList);

        ListView resultView = (ListView) findViewById(R.id.SearchResultListView);
        resultView.setAdapter(resultAdapter);

        Intent intent = getIntent();
        String result = intent.getExtras().getString("RESULT");

        Message newMessage = new Message(result);
        resultAdapter.add(newMessage);
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 2) {
//            String resultMessage = data.getStringExtra("RESULT");
//
//            Message newResult = new Message(resultMessage);
//            resultAdapter.add(newResult);
//        }
//    }
}
