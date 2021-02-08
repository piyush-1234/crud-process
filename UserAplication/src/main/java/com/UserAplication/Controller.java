package com.UserAplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private ServiceImpl service;

	@RequestMapping("/")
	public String index(@ModelAttribute("user") UserDetails user) {

		return "index";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("user") UserDetails user, RedirectAttributes re) {

		service.saveUser(user);
		re.addFlashAttribute("msg", "Registered successfully");
		return "redirect:/";

	}

	@RequestMapping("/show")
	public String showdata(Model model) {
        List<UserDetails> list = service.getAllUserData();
        model.addAttribute("list", list);
		return "showdata";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		Optional<UserDetails> user = service.getUserById(id);
		UserDetails data = user.get();
		model.addAttribute("data", data);
		return "update";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.deleteUserById(id);
		return "redirect:/show";
	}
	
}
