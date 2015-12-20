package meditating.mastermind.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import meditating.mastermind.domain.Category;
import meditating.mastermind.domain.Product;
import meditating.mastermind.service.BidService;
import meditating.mastermind.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private BidService bidService;

	@RequestMapping(value = { "/products", "" }, method = RequestMethod.GET)
	public String list(@ModelAttribute("products") Product product, Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("bids",bidService.getAllBids());
		return "products";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id) {

		productService.deleteProduct(id);
		return "redirect:/products";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") int id, Model model) {

		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("categories", productService.getAllCategory());
		return "editProduct";
	}

	@RequestMapping(value = "/edit/edit/{id}", method = RequestMethod.POST)
	public String editProductSave(@PathVariable("id") int id, @Valid @ModelAttribute("product") Product product,
			BindingResult result) {

		product.setId(id);
		productService.addProduct(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProductForm(@ModelAttribute("newProduct") Product product, Model model) {

		model.addAttribute("categories", productService.getAllCategory());

		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProductSave(@ModelAttribute("newProduct") Product product, HttpServletRequest request) {

		
		System.out.println("--------"+product.getImageFile().getOriginalFilename());

		MultipartFile productImage = product.getImageFile();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				String imageName = product.getCategory()+product.getName() + ".png";
				productImage.transferTo(new File(rootDirectory + "resources\\images\\" + imageName));
				product.setImage(imageName);
				productService.addProduct(product);
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		return "redirect:/products";

	}
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategoryForm(@ModelAttribute("newCategory") Category category) {
		return "addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategorySave(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {

		if (result.hasErrors())
			return "addCategory";

		productService.addCategory(category);

		return "redirect:/products";
	}

}
