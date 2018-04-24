package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.UserVo;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";

	}

	@RequestMapping(value = "/main")
	public String main() {

		System.out.println("main");
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {

		return "/WEB-INF/views/form.jsp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@RequestParam("age") int age, @RequestParam("name") String name) { // handlermapping에 정리됨
		// requestparam에 있는 age를 int age에 담아줌

		UserVo vo = new UserVo(age, name); // 보통은 이렇게 해야 함.

		System.out.println(age);
		System.out.println(name);

		return "";
	}

	@RequestMapping(value = "/add2", method = RequestMethod.GET)
	public String add(@ModelAttribute UserVo userVo) { // new UserVo처럼 담아서 줌

		System.out.println(userVo.toString());
		return "";
	}

	@RequestMapping(value = "/read/{no}", method = RequestMethod.GET)
	public String read(@PathVariable("no") int no) {

		System.out.println(no + "번 글 가져오기");

		return "";
	}

	@RequestMapping(value = "add3", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		return "";
	}
	
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String list(Model model) {
		//Model은 원래 담는거 model은 내가 정한 이름
		
		List<UserVo> userList = new ArrayList<UserVo>();
		UserVo user01 = new UserVo(11, "강다니엘");
		UserVo user02 = new UserVo(22, "옹성우");
		UserVo user03 = new UserVo(33, "박우진");
		
		userList.add(user01);
		userList.add(user02);
		userList.add(user03);
		System.out.println(userList.toString());
		
		
		model.addAttribute("userList", userList);
		//model에 userList랑 return값 담겨서 감.
		return "/WEB-INF/views/index.jsp";
	}
	
}
