package meditating.mastermind.repository;

import org.springframework.data.repository.CrudRepository;

import meditating.mastermind.domain.Bid;

public interface BidRepository extends CrudRepository<Bid, Long>{

}
