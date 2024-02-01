package org.lsi.repositories;

import java.util.List;

import org.lsi.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	List<Complaint> findByEmail(String email);
}
