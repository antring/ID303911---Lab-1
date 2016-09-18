package no.ntnu.mauring.lab1;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by Antring on 18.09.2016.
 */

public class Message implements Serializable {
    String user;
    String message;
    Date timestamp;

    public Message(String message, String user) {
        this.user = user;
        this.message = message;
        this.timestamp = new Date();
    }

    public Message(String message) {
        this.user = "Erik";
        this.message = message;
        this.timestamp = new Date();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
