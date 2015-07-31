package com.id.tick.dto.response;

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
