package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.data.UserRepository;
@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping
	public String registerForm(Model model) {
		
		return "registration";
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		log.info("Registration Form "+form);
		userRepo.save(form.toUser(passwordEncoder));
		
		return "redirect:/login";
		
	}

}
