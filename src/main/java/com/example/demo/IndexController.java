package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping({ "/", "/index" })
@Slf4j
public class IndexController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public String main(Model model) {
		//准备一个空的Post对象给前端
		model.addAttribute("post", new Post()); 
		return "index";
	}

	@PostMapping
	public String save(Post post, Model model) {//富文本编辑器的内容保存在post对象里传回给后端

		//通过console的log能够观察到post的内容
		log.info("post的内容是：" + post);
		
		//保存在数据库
		postRepository.saveAndFlush(post);
		
		//把post传回给前端展示出来
		model.addAttribute("post", post);
		
		return "saved";
	}
}