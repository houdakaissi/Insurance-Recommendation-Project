package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.models.Token;
import com.example.demo.models.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.TokenRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
String lastSignedInUsername;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.println("Generated JWT token length: " + jwt.length());
		System.out.println("Generated JWT token content: " + jwt);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> strRoles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println(strRoles);
		Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

		if (!tokenRepository.existsByUser(user.get())) {
			Token user_token = new Token(jwt, user.get());
			tokenRepository.save(user_token);
		} else {
			Token user_token = new Token(jwt, user.get());
			user_token.setId(tokenRepository.findByUser(user.get()).get().getId());
			System.out.println("id : "+tokenRepository.findByUser(user.get()).get().getId());
			tokenRepository.save(user_token);
			String username = loginRequest.getUsername();
			lastSignedInUsername = username;
		}

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				loginRequest.getPassword(), userDetails.getNom(), userDetails.getPrenom(), userDetails.getCIN(), userDetails.getTel(),
				userDetails.getAcount_address(), strRoles));


	}



/*
	@GetMapping("/user")


	public ResponseEntity<String> getLastSignedInUsername() {

		String j = "{\"username\":\"" + lastSignedInUsername + "\"}";
			return ResponseEntity.ok(j);


	}
*/
	@GetMapping("/user")
	public ResponseEntity<List<User>> getLastSignedInUsername() {
		List<User> userList = new ArrayList<>();

		User user = new User();
		user.setUsername(lastSignedInUsername);

		userList.add(user);

		return ResponseEntity.ok(userList);
	}








	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		User user = new User(
				signUpRequest.getUsername(),
				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getNom(),
				signUpRequest.getPrenom(),
				signUpRequest.getTelephone(),
				signUpRequest.getWallet()
		);

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();




		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			ArrayList<String> listRoles = new ArrayList<>(strRoles);

			switch (listRoles.get(0)) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					user.setAccount_address(signUpRequest.getAcount_address());
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
			}
		}

		user.setRoles(roles);
		user.setAccount_address(signUpRequest.getAcount_address()); // Ensure that acount_address is set

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}


	@PostMapping("/signout")
	public void signout(@RequestBody LoginRequest loginRequest) {
		Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
		tokenRepository.deleteById(tokenRepository.findByUser(user.get()).get().getId());
	}
	@GetMapping("/hello")
	   public String test()
	    {
	        return "Hello amona";
	    }
}
