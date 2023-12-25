package dev.sonnhapi.auth;

import dev.sonnhapi.config.JwtService;
import dev.sonnhapi.entity.Admin;
import dev.sonnhapi.repository.AdminRepository;
import dev.sonnhapi.user.Role;
import dev.sonnhapi.user.User;
import dev.sonnhapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static dev.sonnhapi.user.Role.ADMIN;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);

        if(user.getRole().name() == ADMIN.name()){
            var admin = Admin.builder()
                    .name(request.getName())
                    .user(user)
                    .build();
            adminRepository.save(admin);
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        String username;
        if(user.getRole().name() == ADMIN.name()){
            Admin admin = adminRepository.findByUser_Username(user.getUsername());
        }
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();

    }
}

