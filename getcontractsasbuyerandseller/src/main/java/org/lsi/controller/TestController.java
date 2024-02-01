package org.lsi.controller;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Contract;
import org.lsi.entities.Token;
import org.lsi.repositories.*;
import org.lsi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.entities.User;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
@RestController
@RequestMapping("/api/contrat")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

	@Autowired
	TestService testServ;

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	private ContractRepository contractRepository;

/*
	@GetMapping("/listAsBuyer/{id}")
	public ResponseEntity<List<Contract>> listAsBuyer(@RequestHeader("Authorization") String token, @PathVariable String id) throws Exception {

		User user1 = tokenRepository.findByToken(token).get().getUser();
		ERole erole = ERole.ROLE_USER;
		ERole baserole = ERole.ROLE_USER;
		for (Role b : user1.getRoles()) {
			erole = b.getName();
		}
		if (erole.equals(baserole)) {
			return new ResponseEntity<List<Contract>>(testServ.getAllOfBuyer(id), HttpStatus.OK);
		}
		return null;
	}
	*/
/*
	@GetMapping("/listAsSeller/{id}")
	public ResponseEntity<List<Contract>>listAsSeller(@RequestHeader("Authorization") String token,@PathVariable String id) throws Exception{
//	//tokenRepository.findByUserAndToken(userRepository.findById(id).get(), token).get();
//		userRepository.findById(id).get();
//		tokenRepository.findByUser(userRepository.findById(id).get());
//		System.out.println(tokenRepository.findByUser(userRepository.findById(id).get()).get().getToken());

		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_USER;
		 ERole baserole=ERole.ROLE_USER;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)) {
			return new ResponseEntity<List<Contract>>(testServ.getAllOfSeller(id), HttpStatus.OK);
		}		
		return  null;
	}
*/

	@GetMapping("/listAsBuyer/{id}")
	public ResponseEntity<List<Contract>> listAsBuyer(@PathVariable String id) throws Exception {


			return new ResponseEntity<List<Contract>>(testServ.getAllOfBuyer(id), HttpStatus.OK);


	}

@GetMapping("/listAsSeller/{id}")
public ResponseEntity<List<Contract>> listAsSeller(@PathVariable String id) throws Exception {
	return new ResponseEntity<>(testServ.getAllOfSeller(id), HttpStatus.OK);
}



}
