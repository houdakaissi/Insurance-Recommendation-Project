package org.lsi.service;

import java.math.BigInteger;
import java.util.List;

import org.lsi.entities.Contract;
import org.lsi.entities.User;
import org.lsi.entities.Proprety; // Assuming you have a Proprety class
import org.web3j.tuples.generated.Tuple7;

public interface TestService {
	//Tuple7<String, String, String, String, BigInteger, String, String> Propreties(BigInteger param0) throws Exception;
	//BigInteger PropretyCount() throws Exception;
	//BigInteger getNumberLands() throws Exception;
	List<Contract> getAll();
	// List<Contract> getAllByUsername(String id);
	Contract addLand(User buyer, User seller, BigInteger cost, String desc, Proprety prop, String date,

	  boolean hascar,
	  String meliage,
	  String age,
	  boolean hasstage,
	 String duration,
	  String startFranchise,
	 String endFranchise,
	  boolean hastravel,
	 String destination
	) throws Exception;
//	List<Contract> getAllOfOwner(String id);
}
