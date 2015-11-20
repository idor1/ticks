package com.id.tick.schedule;

/**
 * Created on 19.11.2015.
 */
public class RouteKey {
    private String from;
    private String to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteKey routeKey = (RouteKey) o;

        return from.equals(routeKey.from) && to.equals(routeKey.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
