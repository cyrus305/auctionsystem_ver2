package meditating.mastermind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import meditating.mastermind.domain.Credentials;
import meditating.mastermind.domain.User;
import meditating.mastermind.repository.UserRepository;
import meditating.mastermind.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public User findByUserNumber(Long UserId) {
		return userRepository.findByUserNumber(UserId);
	}

	@Override
	public Credentials isCorrectUsernameAndPassword(String username, String password) {
		final Credentials user = userRepository.getCredentialsByUsername(username);
		// System.out.println(user.getRole());
		if (user == null) {
			return null;
		} else {
			// set authorization
			List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
			GrantedAuthority grantedAuthority = new GrantedAuthority() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public String getAuthority() {
					return user.getRole();
				}
			};
			authority.add(grantedAuthority);

			Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(),
					authority);

			SecurityContextHolder.getContext().setAuthentication(authentication);

			// BCryptPasswordEncoder passwordEncoder = new
			// BCryptPasswordEncoder();
			// String hashedPassword = passwordEncoder.encode(password);
			//
			// System.out.println(hashedPassword+": "+user.getPassword());

			if (user.getPassword().equals(password)) {
				return user;
			}
			return null;
		}
	}

}
