package com.logistiqal.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.logistiqal.LogistiqalCompanyApplication;
import com.logistiqal.model.Product;
import com.logistiqal.service.ProductService;
import com.logistiqal.vo.ProductVO;

@Controller
public class ProductController {
	
	private static final Logger log = Logger.getLogger(LogistiqalCompanyApplication.class);
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/home"})
	public String home(Model model) {
		model.addAttribute("VO", productService.getAllProducts());
		return "home";
	}

	@GetMapping({"/addForm"})
	public String add(Model model) {
		return "addForm";
	}

	@PostMapping({"/add"})
	public ModelAndView add(@ModelAttribute Product product, RedirectAttributes ra) {
		ProductVO response = productService.add(product);
		System.out.println(response.getStatusCode());
		ra.addFlashAttribute("msj", response.getMessage());
		if (response.getStatusCode() != "0") {
			return new ModelAndView("redirect:/addForm");
		} else {
			return new ModelAndView("redirect:/home");
		}
	}

	@GetMapping({"/updateForm"})
	public String update(Model model) {
		return "updateForm";
	}

	@PostMapping({"/update"})
	public ModelAndView update(@ModelAttribute Product product, RedirectAttributes ra) {
		ProductVO response = productService.update(product);
		ra.addFlashAttribute("mjs", response.getMessage());
		if (response.getStatusCode() != "0") {
			return new ModelAndView("redirect:/updateForm");
		} else {
			return new ModelAndView("redirect:/home");
		}
	}

	@GetMapping({"/delete"})
	public ModelAndView delete(Model model, @RequestParam String idProduct, RedirectAttributes ra) {
		
		ProductVO response = new ProductVO();
		response.setMessage("Could not delete user, sorry.");
		
		try {
			Product productToDelete = new Product();
			productToDelete.setIdProduct(Long.parseLong(idProduct));
			response = productService.delete(productToDelete);
			ra.addFlashAttribute("msj", response.getMessage());

			return new ModelAndView("redirect:/home");

		} catch (Exception e) {
			log.error("Error has ocurred in delete method from ProductController. " + e);
		}

		ra.addFlashAttribute("msj", response.getMessage());
		response = productService.getAllProducts();
		ra.addAttribute("VO", response);

		return new ModelAndView("redirect:/home");

	}
	
	

}
