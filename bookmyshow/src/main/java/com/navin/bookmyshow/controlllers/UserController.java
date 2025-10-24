package com.navin.bookmyshow.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.navin.bookmyshow.dtos.ResponseStatus;
import com.navin.bookmyshow.dtos.SignUpRequestDTO;
import com.navin.bookmyshow.dtos.SignUpResponseDTO;
import com.navin.bookmyshow.models.User;
import com.navin.bookmyshow.services.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO response = new SignUpResponseDTO();
        try {
            User user = userService.signUp(
                    signUpRequestDTO.getEmail(),
                    signUpRequestDTO.getPassword());
            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

}
