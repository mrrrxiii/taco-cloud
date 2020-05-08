package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import tacos.User;
@Data
public class RegistrationForm {
	
	private final String username;
	private final String password;
	private final String fullname;
	private final String street;
	private final String city;
	private final String state;
	private final String zip;
	private final String phone;

	public User toUser(PasswordEncoder passwordEncoder) {
		// TODO Auto-generated method stub
		return new User(
				username, passwordEncoder.encode(password),
				fullname, street, city, state, zip, phone);
	}

}
