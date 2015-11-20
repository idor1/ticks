package com.id.tick.schedule;

import com.id.tick.dto.ui.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 16.11.2015.
 */
@Service
public class ScheduleRequestService {
    private Map<String, Collection<BookingRequest>> unprocessedRequests;

    public Map<String, Collection<BookingRequest>> getUnprocessedRequests() {
        return unprocessedRequests;
    }

    public void setUnprocessedRequests(Map<String, Collection<BookingRequest>> unprocessedRequests) {
        this.unprocessedRequests = unprocessedRequests;
    }
}
