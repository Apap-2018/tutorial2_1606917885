package com.example.demo.controller;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageContoller {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

	@RequestMapping(value = {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", required = false, 
		defaultValue = "0") int a, @RequestParam(value = "b", required = false, 
		defaultValue = "0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		String generatorA = "";
		if (a <= 1) {
			generatorA += "hm";
		}
		else {
			generatorA += "h";
			for(int i = 0; i < a; i++) {
				generatorA += "m";
			}
		}
		
		String generatorB = "";
		if (b <= 1) {
			generatorB += "hm";
		}
		else {
			for (int i = 0; i < b; i++) {
				generatorB += generatorA + " ";
			}
		}
		
		model.addAttribute("result", generatorB);
		return "generator";
	}
}
