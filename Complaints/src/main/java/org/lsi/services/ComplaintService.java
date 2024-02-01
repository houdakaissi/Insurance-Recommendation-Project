package org.lsi.services;

import java.util.List;

import org.lsi.entities.Complaint;

public interface ComplaintService {
    void addComplaint(Complaint c);
    List<Complaint> getAll();
}
