package vn.iostar.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;

@Service
public record UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
	public String addUser(User userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Thêm user thành công!";
	}
}