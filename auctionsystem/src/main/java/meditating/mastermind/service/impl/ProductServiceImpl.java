package meditating.mastermind.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import meditating.mastermind.domain.Category;
import meditating.mastermind.domain.Product;
import meditating.mastermind.repository.CategoryRepository;
import meditating.mastermind.repository.ProductRepository;
import meditating.mastermind.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(Category category) {

		categoryRepository.save(category);

	}

	public void addProduct(Product product) {
		productRepository.save(product);

	}

	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	public List<Category> getAllCategory(){
		return (List<Category>) categoryRepository.findAll();
	}

	public void deleteProduct(int id) {
		productRepository.delete(id);
		
	}

	public Product getProductById(int id) {
		return productRepository.findOne(id);
	}

}
