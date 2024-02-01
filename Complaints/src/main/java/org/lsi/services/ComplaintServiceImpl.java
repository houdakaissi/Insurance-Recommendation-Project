package org.lsi.services;

import java.util.List;

import org.lsi.entities.Complaint;
//import org.lsi.repositories.ComplaintJpaRepository; // Assuming you have a JPA repository for Complaint
import org.lsi.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository compJpaRepository;

	@Override
	public void addComplaint(Complaint c) {
		compJpaRepository.save(c);
	}

	@Override
	public List<Complaint> getAll() {
		return compJpaRepository.findAll();
	}
}
