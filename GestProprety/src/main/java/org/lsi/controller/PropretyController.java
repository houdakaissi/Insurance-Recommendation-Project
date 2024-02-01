package org.lsi.controller;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Proprety;
import org.lsi.services.PropretyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.entities.User;
import org.lsi.repository.TokenRepository;
import org.lsi.repository.UserRepository;
@RestController
@RequestMapping("/api/propreties/")
public class PropretyController {
	
	@Autowired
	PropretyService propServ;

	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/saveProprety")
	  public ResponseEntity<Proprety> saveProprety(@RequestHeader("Authorization") String token,@RequestBody Proprety prop) {
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)) {
		  propServ.addProprety(prop);
          return new ResponseEntity<Proprety>(prop, HttpStatus.OK);
		}
		return null;
  }
	
	@GetMapping("/propreties/{id}")
	public ResponseEntity<?> getAllProp(@RequestHeader("Authorization") String token,@PathVariable("id") String id){
		User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 ERole baserole1=ERole.ROLE_USER;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole) || erole.equals(baserole1)){
		List<Proprety> prop = propServ.getByUserId(id);
		if(prop.size() > 0) {
			return new ResponseEntity<List<Proprety>>(prop, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No todos available", HttpStatus.NOT_FOUND);
		}
		}
		return null;
	}
	
	@PutMapping("/updateProp/{id}")
  public ResponseEntity<Proprety> updateProp(@RequestHeader("Authorization") String token,@PathVariable("id") String id,@RequestBody Proprety prop) {
	  User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole)){
		Proprety prop1=propServ.updateProprety(id,prop);
		 return new ResponseEntity<Proprety>(prop1, HttpStatus.OK);
		}
		return null;
  }
	 
	 
	 @GetMapping("/getPropById/{id}")
	  public ResponseEntity<Proprety> getPropById(@RequestHeader("Authorization") String token,@PathVariable("id") String id) {
	    User user1=tokenRepository.findByToken(token).get().getUser();
		 ERole erole=ERole.ROLE_ADMIN;
		 ERole baserole=ERole.ROLE_ADMIN;
		 ERole baserole2=ERole.ROLE_USER;
		 for(Role b:user1.getRoles()){  
			  erole=b.getName(); 
		}  
		if(erole.equals(baserole) || erole.equals(baserole2)) {
		Optional<Proprety> prop = propServ.getById(id);

	    if (prop.isPresent()) {
	      return new ResponseEntity<>(prop.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		}
		return null;
	  }

}
