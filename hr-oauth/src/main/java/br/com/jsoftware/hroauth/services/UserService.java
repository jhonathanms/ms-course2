package br.com.jsoftware.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jsoftware.hroauth.entities.User;
import br.com.jsoftware.hroauth.feignclients.UserFeignClients;

@Service
public class UserService implements UserDetailsService{

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClients clients;

//	public User findByEmail(String email) {
//
////		return Optional.ofNullable(
////				clients.findByEmail(email).getBody())
////				.orElseThrow(() -> new NullPointerException("Nenhum email foi encontrado"));
//		
//		User user = clients.findByEmail(email).getBody();
//		
//		if (user == null) {
//			log.error("Email not found" + email);
//			throw new IllegalArgumentException("Email not found");
//		}
//		
//		log.info("Email found:" + email);
//		return user;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = clients.findByEmail(username).getBody();
		
		if (user == null) {
			log.error("Email not found" + username);
			throw new UsernameNotFoundException("Email not found");
		}
		
		log.info("Email found:" + username);
		return user;
	}

}
