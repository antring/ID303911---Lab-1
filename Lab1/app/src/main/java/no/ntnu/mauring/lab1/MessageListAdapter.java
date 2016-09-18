package no.ntnu.mauring.lab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Antring on 18.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {
    public MessageListAdapter(Context context, List<Message> messages) {
        super(context, 0, messages);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        String messageText;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout,parent,false);
        }


        TextView messageView = (TextView)convertView.findViewById(R.id.textView);

        messageText = message.getUser() + ":\n" + message.getMessage();
        messageView.setText(messageText);

        return convertView;
    }
}
