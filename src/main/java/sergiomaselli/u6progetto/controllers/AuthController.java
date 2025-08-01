package sergiomaselli.u6progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.exceptions.ValidationException;
import sergiomaselli.u6progetto.payloads.LoginDTO;
import sergiomaselli.u6progetto.payloads.LoginRespDTO;
import sergiomaselli.u6progetto.payloads.NewUserDTO;
import sergiomaselli.u6progetto.payloads.NewUserRespDTO;
import sergiomaselli.u6progetto.services.AuthService;
import sergiomaselli.u6progetto.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody LoginDTO body) {
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginRespDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserRespDTO register(@RequestBody @Validated NewUserDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors()
                    .stream()
                    .map(err -> err.getDefaultMessage())
                    .toList());
        }
        User newUser = userService.save(payload);
        return new NewUserRespDTO(newUser.getId());
    }
}
