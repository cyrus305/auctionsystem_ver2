package meditating.mastermind.service;

import java.util.List;

import meditating.mastermind.domain.Credentials;
import meditating.mastermind.domain.User;

public interface UserService {
	public void save(User user);
	public List<User> findAll();
	public User findByUserNumber(Long userId);
	public Credentials isCorrectUsernameAndPassword(String username, String password);
}
