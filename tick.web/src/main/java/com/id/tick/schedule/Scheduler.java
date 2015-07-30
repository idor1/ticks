package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.BookingRequest;
import com.id.tick.dto.Route;
import com.id.tick.dto.RouteVariant;
import com.id.tick.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on 09.07.2015.
 */
@Service
public class Scheduler {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private BookingManager bookingManager;

    private Map<String, BookingRequest> references = new HashMap<String, BookingRequest>();

    public String scheduleBooking(BookingRequest bookingRequest) {
        String ref = String.valueOf(new Random().nextInt());

        bookingManager.bookTickets(bookingRequest);

        references.put(ref, bookingRequest);
//        try {
//            mailSender.generateAndSendEmail(bookingRequest.getEmail());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return ref;
    }
}
