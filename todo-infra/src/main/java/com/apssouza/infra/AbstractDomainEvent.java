package com.apssouza.infra;

import java.time.Instant;


public abstract class AbstractDomainEvent implements AppEvent {

    protected  String uuid;
    
    protected Instant when = Instant.now();

    @Override
    public String uuid() {
        return uuid;
    }

    @Override
    public Instant when() {
        return when;
    }
}
