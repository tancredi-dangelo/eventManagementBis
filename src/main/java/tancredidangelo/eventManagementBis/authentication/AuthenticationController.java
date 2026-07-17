package tancredidangelo.eventManagementBis.authentication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tancredidangelo.eventManagementBis.eventCreator.EventCreatorService;
import tancredidangelo.eventManagementBis.login.LoginRequestDTO;
import tancredidangelo.eventManagementBis.login.LoginResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    /// dependency injection AuthenticationService + EventCreatorService
    private final AuthenticationService authenticationService;
    private final EventCreatorService eventCreatorService;

    public AuthenticationController(AuthenticationService authenticationService, EventCreatorService eventCreatorService) {
        this.authenticationService = authenticationService;
        this.eventCreatorService = eventCreatorService;
    }


    /// Log In
    @PostMapping("/login")
    @ResponseStatus()
    public LoginResponseDTO login(LoginRequestDTO body) {
        return new LoginResponseDTO(this.authenticationService.checkCredentialsAndVerifyToken(body));
    }



    /// Register
    @PostMapping("/register")
}
