package meditating.mastermind.repository;

import org.springframework.data.repository.CrudRepository;

import meditating.mastermind.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
