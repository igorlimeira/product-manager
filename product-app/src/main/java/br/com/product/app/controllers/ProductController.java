package br.com.product.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.product.app.models.Product;
import br.com.product.app.repositories.ProductRepository;
@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/lap")
	public List<Product> listAllProducts() {
		return this.productRepository.findAll();
	}
	
	@GetMapping("/lp/{id}")
	public Optional<Product> listProduct(@PathVariable(name = "id")  Long id) {
		Optional<Product> product = this.productRepository.findById(id);
		if(product.isPresent()) {
			return product;
		}else {
			throw new RuntimeException("Produto " + id + " não encontrado!");
		}
	}

	@PostMapping("/save")
	public Product insertProduct(@RequestBody Product product) {
		if(StringUtils.isEmpty(product.getBarCode())
				|| StringUtils.isEmpty(product.getDescription())
				|| product.getPrice() == null){
			throw new RuntimeException("Invalid Data");
		}
		return this.productRepository.saveAndFlush(product);
	}

	@DeleteMapping("delete/{id}")
	public Product deleteProduct(@PathVariable(name = "id")  Long id) {
		Optional<Product> product = this.productRepository.findById(id);
		if(product.isPresent()) {
			Product deletedProduct = product.get();
			this.productRepository.deleteById(id);
			return deletedProduct;
		}else{
			throw new RuntimeException("ID " + id + " não existe!");
		}
	}

//	@PutMapping("/update")
//	public String updateProduct(@RequestBody Product product) {
//		boolean isPresent = this.productRepository.findById(product.getId()).isPresent();
//		if(isPresent) {
//			this.productRepository.saveAndFlush(product);
//			return "ID " + product.getId() + " alterado com sucesso!";
//		}else{
//			throw new RuntimeException("ID " + product.getId() + " não existe!");
//		}
//	}

}

