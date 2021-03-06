package meditating.mastermind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import meditating.mastermind.domain.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
