package com.apssouza.infra;

import java.time.Instant;


public interface AppEvent {

    String uuid();

    Instant when();

}
