package tancredidangelo.eventManagementBis.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tancredidangelo.eventManagementBis.eventCreator.EventCreator;
import tancredidangelo.eventManagementBis.eventCreator.EventCreatorService;
import tancredidangelo.eventManagementBis.exceptionHandling.exceptions.UnauthorizedException;
import tancredidangelo.eventManagementBis.login.LoginRequestDTO;
import tancredidangelo.eventManagementBis.security.JWTTools;

@Service
@Slf4j
public class AuthenticationService {

    /// dependency injection Event Creator Service + JWT Tools
    private final EventCreatorService eventCreatorService;
    private final JWTTools jwtTools;

    public AuthenticationService(EventCreatorService eventCreatorService, JWTTools jwtTools) {
        this.eventCreatorService = eventCreatorService;
        this.jwtTools = jwtTools;
    }


    /// check credentials and generate token
    public String checkCredentialsAndVerifyToken(LoginRequestDTO body) {

        EventCreator found = this.eventCreatorService.findByEmail(body.email());

        if (found.getPassword().equals(body.password())) {
            // credentials ok
            return this.jwtTools.generateToken(found);
        }
        else {
            // credentials wrong
            throw new UnauthorizedException("Wrong credentials. Try again");
        }

    }
}
