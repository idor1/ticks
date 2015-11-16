package com.id.tick.dto.request;

import com.id.tick.dto.request.Luggage;
import com.id.tick.dto.request.Person;

/**
 * Created on 30.07.2015.
 */
public class SeatBookingRequest {
    private Person person;
    private Luggage luggage;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }
}
