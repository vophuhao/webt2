package vn.iostar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import vn.iostar.entity.User;
import vn.iostar.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userServices;

	@Autowired
    public UserController(UserService userServices) {
        this.userServices = userServices;
    }
	@PostMapping("/new")
	public String addUser(@RequestBody User userInfo) {
		return userServices.addUser(userInfo);
	}
}