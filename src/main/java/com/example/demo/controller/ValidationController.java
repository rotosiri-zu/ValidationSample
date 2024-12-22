package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.from.CalcForm;

@Controller
public class ValidationController {
	/**「form-backing bean」の初期化*/
	@ModelAttribute
	public CalcForm setUpForm() {
		return new CalcForm();
	}
	
	/** 入力画面を表示する */
	@GetMapping("show")
	public String showView() {
		// 戻り値は「ビュー名」を返す
		return "entry";
	}
}
