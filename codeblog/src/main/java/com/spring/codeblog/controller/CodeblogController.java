package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

import jakarta.validation.Valid;

@Controller
public class CodeblogController {

	@Autowired
	CodeblogService codeblogService;
	
	@GetMapping(path = "/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@GetMapping("/posts/{id}")
	public ModelAndView getPostsDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@GetMapping("/newpost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping("/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem","Verifique se os campos obrigatorios foram preenchidos");
			return "redirect:/newpost";
		}
		
		post.setData(LocalDate.now());
		codeblogService.save(post);
		return "redirect:/posts";
		
	}	
}
