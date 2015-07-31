package com.id.tick.dto.response;

import java.util.Collection;

/**
 * Created on 23.06.2015.
 */
public class Stations {
    private Collection<Station> stations;

    public Collection<Station> getStations() {
        return stations;
    }

    public void setStations(Collection<Station> stations) {
        this.stations = stations;
    }
}
