package com.pablito.sdahelper.observerSolution;

import com.pablito.sdahelper.singelton.Logger;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class EmailGatewayMockup implements Observer {
    @Override
    public void update(final Observable o, final Object arg) {
        Attendee attendee = (Attendee) arg;
        try {
            Logger.get().log(String.format("Sending email we got new attendee it is: %s", attendee));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
