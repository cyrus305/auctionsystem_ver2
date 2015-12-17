package meditating.mastermind.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity(name = "tbl_product")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	@Size(min = 4, max = 50, message = "{product.validation.size}")
	private String name;

	@Column(name = "description")
	@Size(min = 5, max = 50, message = "{product.validation.size}")
	private String description;

	@Valid
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	@Transient
	private MultipartFile imageFile;

	@Column(name = "image")
	private String image;

	@Column(name = "minBiddingPrice")
	private Double minBiddingPrice;

	@Column(name = "timeToBid")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date timeToBid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getMinBiddingPrice() {
		return minBiddingPrice;
	}

	public void setMinBiddingPrice(Double minBiddingPrice) {
		this.minBiddingPrice = minBiddingPrice;
	}

	public Date getTimeToBid() {
		return timeToBid;
	}

	public void setTimeToBid(Date timeToBid) {
		this.timeToBid = timeToBid;
	}

}
