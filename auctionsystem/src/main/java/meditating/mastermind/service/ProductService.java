package meditating.mastermind.service;

import java.util.List;

import meditating.mastermind.domain.Category;
import meditating.mastermind.domain.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	void addProduct(Product product);
	void addCategory(Category category);
	void deleteProduct(int id);
	public List<Category> getAllCategory();
	public Product getProductById(int id);
	
}
