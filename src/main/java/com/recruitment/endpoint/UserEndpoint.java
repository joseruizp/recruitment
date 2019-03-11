package com.recruitment.endpoint;

import com.recruitment.service.UserService;
import com.recruitment.dto.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/")
    public ResponseEntity<Object> createUser(@RequestBody UserView userView) {

        userService.createUser(userView);

        return ResponseEntity.noContent().build();
    }


}
