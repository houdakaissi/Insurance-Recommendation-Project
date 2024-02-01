package org.lsi.service;


import java.util.List;

import org.lsi.entities.Contract;

public interface TestService {
	
	public List<Contract> getAllOfBuyer(String id);
	public List<Contract> getAllOfSeller(String id);
}
