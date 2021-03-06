package com.bethelhouseofworship.BethelHOW.Controllers;

import java.util.Objects;

import com.bethelhouseofworship.BethelHOW.Services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.bethelhouseofworship.BethelHOW.Config.JwtTokenUtil;
import com.bethelhouseofworship.BethelHOW.Models.JwtRequest;
import com.bethelhouseofworship.BethelHOW.Models.JwtResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {


        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private JwtUserDetailsService jwtInMemoryUserDetailsService;

        @PostMapping("/authenticate")
        public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
                throws Exception {

            System.out.println(authenticationRequest.getUsername());
            System.out.println(authenticationRequest.getPassword());

            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = jwtInMemoryUserDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);
            System.out.println("In authenticate controller: token - " + token);

            return ResponseEntity.ok(new JwtResponse(token));
        }

        private void authenticate(String username, String password) throws Exception {
            Objects.requireNonNull(username);
            Objects.requireNonNull(password);
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
        }
}

