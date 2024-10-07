package vn.iostar.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;

public class UserInfoService implements UserDetailsService {
	@Autowired
	UserRepository repository;
	public UserInfoService (UserRepository userRepository) {
	this.repository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
	Optional<User> user = repository.findByUsername(username); 
	return user.map(UserInfoUserDetails::new)
	.orElseThrow(() -> new UsernameNotFoundException("user not found: " +username));
	}

}