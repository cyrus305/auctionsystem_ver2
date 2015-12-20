package meditating.mastermind.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import meditating.mastermind.domain.Bid;
import meditating.mastermind.domain.Product;
import meditating.mastermind.domain.User;
import meditating.mastermind.service.BidService;
import meditating.mastermind.service.ProductService;

@Controller
public class BidController {
	
	@Autowired
	BidService bidService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value={"/addBid"} ,method=RequestMethod.POST)
	public @ResponseBody Bid addBid(@RequestBody Bid bid,HttpSession session){
		User user=(User) session.getAttribute("loggedInUser");
		System.out.println(user.getId());
		
		Product product = productService.getProductById(bid.getId());
		
		product.setMinBiddingPrice(bid.getBidPrice());
		productService.addProduct(product);
		
		System.out.println(bid.getId());
		System.out.println(product.getDescription());
		System.out.println(bid.getBidPrice());
		
		bid.setUser(user);

		bid.setProduct(product);
		
		bidService.save(bid);
		return bid;
		
	}
	
	

}
