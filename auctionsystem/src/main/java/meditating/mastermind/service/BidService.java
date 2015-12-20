package meditating.mastermind.service;

import java.util.List;

import meditating.mastermind.domain.Bid;

public interface BidService {

	void save(Bid bid);
	public List<Bid> getAllBids();

}