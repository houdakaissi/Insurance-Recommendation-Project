package org.lsi.controller;


import org.lsi.entities.Contract;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
import org.lsi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

	@Autowired
	private TestService testServ;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private UserRepository userRepository;
/*
	@PostMapping("/addContract")
	public ResponseEntity<?> addContract(@RequestHeader("Authorization") String token, @RequestBody Contract contract) {
		// Your authentication logic here (check user roles, etc.)
		// For simplicity, I'm assuming any authenticated user can add a contract.
		// Modify this based on your authentication requirements.

		// Example: Get the user roles
		//List<Role> roles = tokenRepository.findByToken(token).orElseThrow().getUser().getRoles();

		// Example: Check if the user has the required role (ROLE_ADMIN)
		//boolean isAdmin = roles.stream().anyMatch(role -> role.getName() == ERole.ROLE_ADMIN);
		Set<Role> roless= tokenRepository.findByToken(token).orElseThrow().getUser().getRoles();
		boolean isAdmin = roless.stream().anyMatch(role -> role.getName() == ERole.ROLE_ADMIN);
	try{
		if (isAdmin) {
			Contract savedContract = testServ.addLand(contract.getBuyer(),
					contract.getSeller(),
					contract.getCost(),
					contract.getDesc(),
					contract.getProp(), // Assuming 'getProp' is a method in the Contract class
					contract.getDate());
			return new ResponseEntity<>(savedContract, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
		}
	} catch (Exception e) {
		// Handle the exception, log it, or take appropriate action
		e.printStackTrace(); // This is just an example, replace with proper logging
		return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

*/


	@PostMapping("/addContract")
	public ResponseEntity<?> addContract(@RequestBody Contract contract) {
		try {
			// Assuming any request reaching this endpoint is considered authorized
			Contract savedContract = testServ.addLand(
					contract.getBuyer(),
					contract.getSeller(),
					contract.getCost(),
					contract.getDesc(),
					contract.getProp(),
					contract.getDate(),


					contract.isHasCar(),
					contract.getMileage(),
					contract.getAge(),
					contract.isHasStage(),
					contract.getDuration(),
					contract.getStartFranchise(),
					contract.getEndFranchise(),
						contract.isHasTravel(),
					contract.getDestination()
			       );

			return new ResponseEntity<>(savedContract, HttpStatus.OK);
		} catch (Exception e) {
			// Handle the exception, log it, or take appropriate action
			e.printStackTrace(); // This is just an example, replace with proper logging
			return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}






@Autowired
public	RestTemplate  restTemplate;








	@GetMapping("/listContracts")
	public ResponseEntity<List<Contract>> listContracts() {
		//String url="http://localhost:8083/api/auth/signin";
      // Object[] objects=restTemplate.getForObject(url,Object[].class);

		//: Get all contracts from the database
		List<Contract> contracts = testServ.getAll();

	//	List<Contract> contracts = testServ.getAllByUsername(id);
				 return new ResponseEntity<>(contracts, HttpStatus.OK);
	}

/*
	@GetMapping("/listContract")
	public ResponseEntity<List<Object>> listContract() {
		String externalApiUrl = "http://localhost:8083/api/auth/user";
		Object[] externalContracts = restTemplate.getForObject(externalApiUrl, Object[].class);


	 //abase
	//	List<Contract> localContracts = testServ.getAll();

		// Combine external and local contracts into a single list
		List<Object> allContracts = Arrays.asList(externalContracts);
	//	allContracts.addAll(localContracts);

		// Return the combined list in the ResponseEntity
		return new ResponseEntity<>(allContracts, HttpStatus.OK);
	}
	*/

	@GetMapping("/listContract")
	public ResponseEntity<List<Object>> listContract() {
		String externalApiUrl = "http://localhost:8083/api/auth/user";
		// Use parameterized ResponseEntity to indicate a list of objects
		ResponseEntity<List<Object>> responseEntity = restTemplate.exchange(
				externalApiUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Object>>() {});

		List<Object> externalContracts = responseEntity.getBody();

		// If you have localContracts, add them here as well
		// List<Contract> localContracts = testServ.getAll();
		// externalContracts.addAll(localContracts);

		return new ResponseEntity<>(externalContracts, HttpStatus.OK);
	}

	@GetMapping("/listContrac")
	public ResponseEntity<List<Object>> listContrac() {
		// Call the external API to get contracts
		String externalApiUrl = "http://localhost:8083/api/auth/user";
		ResponseEntity<List<Object>> externalApiResponse = restTemplate.exchange(
				externalApiUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Object>>() {});

		List<Object> externalContracts = externalApiResponse.getBody();

		// Get contracts from the database
		List<Contract> localContracts = testServ.getAll();

		// Combine the external and local contracts into a single list
		List<Object> allContracts = new ArrayList<>();
		allContracts.addAll(externalContracts);
		allContracts.addAll(localContracts);

		return new ResponseEntity<>(allContracts, HttpStatus.OK);
	}








}

