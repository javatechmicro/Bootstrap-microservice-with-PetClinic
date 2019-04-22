package com.apssouza.services;

import java.util.List;

import com.apssouza.pojos.Visits;

/**
 *
 * @author Mohammad
 */
public interface VisitService {
    
    public List<Visits> getAll();

    public List<Visits> getVisitsByEmaill(String email);

    Visits createVisits(Visits visit);
}
