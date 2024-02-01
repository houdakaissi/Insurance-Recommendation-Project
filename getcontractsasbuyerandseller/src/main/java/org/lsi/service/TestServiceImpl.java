package org.lsi.service;

import org.lsi.entities.Contract;
import org.lsi.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

// ...

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private ContractRepository contractRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Contract> getAllOfBuyer(String id) {
		List<Contract> resultList = new ArrayList<>();

		// Using JpaRepository findAll method
		// List<Contract> allContracts = contractRepository.findAll();

		// Using JPQL query
		Query query = entityManager.createQuery("SELECT c FROM Contract c");
		List<Contract> allContracts = query.getResultList();

		for (Contract contract : allContracts) {
			if (id.equals(contract.getBuyer().getId().toString())) {
				resultList.add(contract);
			}
		}
		return resultList;
	}

	@Override
	public List<Contract> getAllOfSeller(String id) {
		List<Contract> resultList = new ArrayList<>();

		// Using JpaRepository findAll method
		// List<Contract> allContracts = contractRepository.findAll();

		// Using JPQL query
		Query query = entityManager.createQuery("SELECT c FROM Contract c");
		List<Contract> allContracts = query.getResultList();

		for (Contract contract : allContracts) {
			if (id.equals(contract.getSeller().getId().toString())) {
				resultList.add(contract);
			}
		}
		return resultList;
	}
}
