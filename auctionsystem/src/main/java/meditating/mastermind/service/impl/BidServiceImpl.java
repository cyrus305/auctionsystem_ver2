package meditating.mastermind.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meditating.mastermind.domain.Bid;
import meditating.mastermind.repository.BidRepository;
import meditating.mastermind.service.BidService;

@Service
public class BidServiceImpl implements BidService {
	
	@Autowired
	BidRepository bidRepository;
	
	@Override
	public void save(Bid bid){
		bidRepository.save(bid);
	}
	
	public List<Bid> getAllBids(){
		return (List<Bid>) bidRepository.findAll();
	}

}
