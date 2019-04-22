package com.apssouza.events;

import com.apssouza.entities.ToDo;
import com.fasterxml.jackson.annotation.JsonIgnore;


public interface TodoChangedEvent {

    @JsonIgnore
    int getPriority();

    ToDo getTodo();

}
