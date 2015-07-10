package com.id.tick.dto;

import java.util.Collection;

/**
 * Created on 23.06.2015.
 */
public class Route {
    private Collection<RouteVariant> vars;

    public Collection<RouteVariant> getVars() {
        return vars;
    }

    public void setVars(Collection<RouteVariant> vars) {
        this.vars = vars;
    }
}
