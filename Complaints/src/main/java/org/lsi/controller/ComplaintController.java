package org.lsi.controller;
// ComplaintController.java
import org.apache.catalina.filters.ExpiresFilter;
import org.lsi.entities.Complaint;
import org.lsi.entities.ERole;
import org.lsi.entities.Role;
import org.lsi.entities.User;
import org.lsi.repositories.TokenRepository;
import org.lsi.repositories.UserRepository;
import org.lsi.services.ComplaintService;
import org.lsi.services.EmailSenderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll
import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
@CrossOrigin(origins = "http://localhost:4200")
public class ComplaintController {

	@Autowired
	ComplaintService compServ;

	@Autowired
	private EmailSenderServiceImp service;

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	UserRepository userRepository;
/*
	@GetMapping("/listComplaints")
	public ResponseEntity<List<Complaint>> listComplaints(@RequestHeader("Authorization") String token) throws Exception {
		System.out.println("Received token: " + token);
		User user1 = tokenRepository.findByToken(token).get().getUser();
		ERole erole = ERole.ROLE_ADMIN;
		ERole baserole = ERole.ROLE_ADMIN;
		for (Role b : user1.getRoles()) {
			erole = b.getName();
		}
		if (erole.equals(baserole)) {
			return new ResponseEntity<List<Complaint>>(compServ.getAll(), HttpStatus.OK);
		}
		return null;
	}

	*/
@GetMapping("/listComplaints")
public ResponseEntity<List<Complaint>> listComplaints() {
	// Remove the Authorization header parameter and related token logic
	// ...

	// Simply return the list of complaints without any authorization check
	return new ResponseEntity<List<Complaint>>(compServ.getAll(), HttpStatus.OK);
}


	/*@PostMapping("/addComplaint")
	public ResponseEntity<Complaint> addComplaint(@RequestHeader("Authorization") String token, @RequestBody Complaint c) throws Exception {
		User user1 = tokenRepository.findByToken(token).get().getUser();
		ERole erole = ERole.ROLE_ADMIN;
		ERole baserole = ERole.ROLE_USER;
		for (Role b : user1.getRoles()) {
			erole = b.getName();
		}
		if (erole.equals(baserole)) {
			compServ.addComplaint(c);
			return new ResponseEntity<Complaint>(c, HttpStatus.OK);
		}
		return null;
	}
*/
	@PostMapping("/addComplaint")
	public ResponseEntity<Complaint> addComplaint(@RequestBody Complaint c) {
		// No authorization or token checks
		compServ.addComplaint(c);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}


	@PostMapping("/sendResponse")
	public ResponseEntity<Complaint> sendResponse(@RequestHeader("Authorization") String token, @RequestBody Complaint c) throws Exception {
		User user1 = tokenRepository.findByToken(token).get().getUser();
		ERole erole = ERole.ROLE_ADMIN;
		ERole baserole = ERole.ROLE_ADMIN;
		for (Role b : user1.getRoles()) {
			erole = b.getName();
		}
		if (erole.equals(baserole)) {
			service.sendSimpleEmail(c.getEmail(),
					c.getReponse(),
					"Reponse a votre reclamation");
			compServ.addComplaint(c);
			return new ResponseEntity<Complaint>(c, HttpStatus.OK);
		}
		return null;
	}
}
