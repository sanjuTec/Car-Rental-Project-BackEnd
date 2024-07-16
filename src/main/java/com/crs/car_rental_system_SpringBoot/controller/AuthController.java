package com.crs.car_rental_system_SpringBoot.controller;

import com.crs.car_rental_system_SpringBoot.dto.AuthenticationRequest;
import com.crs.car_rental_system_SpringBoot.dto.AuthenticationResponse;
import com.crs.car_rental_system_SpringBoot.dto.SignupRequest;
import com.crs.car_rental_system_SpringBoot.dto.UserDTO;
import com.crs.car_rental_system_SpringBoot.entity.User;
import com.crs.car_rental_system_SpringBoot.repository.UserRepository;
import com.crs.car_rental_system_SpringBoot.services.auth.AuthService;
import com.crs.car_rental_system_SpringBoot.services.jwt.UserService;
import com.crs.car_rental_system_SpringBoot.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signUpRequest){
        if(authService.hasUserWithEmail(signUpRequest.getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("User already exist with this email");
        }
        UserDTO createUserDTO = authService.signupUser(signUpRequest);
        if(createUserDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User not created");
        }
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(createUserDTO);

    }

    @PostMapping(value = "/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getEmail());
        final String jwtToken = jwtUtils.generateToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if(optionalUser.isPresent()){
            authenticationResponse.setJwt(jwtToken);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }
        return authenticationResponse;

    }
}
