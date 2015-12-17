package meditating.mastermind.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import meditating.mastermind.domain.Credentials;
import meditating.mastermind.domain.User;

	@Repository
	public interface UserRepository extends  CrudRepository<User, Long> 
	{
		@Query("select u from User u where u.credentials.id= :id")
		public User findByUserNumber(@Param("id") Long userNumber);
		@Query("select c from Credentials c where c.username=:username")
		public Credentials getCredentialsByUsername(@Param("username") String username);
		
 	}
