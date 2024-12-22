package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	/** 確認画面を表示する : Fromクラス使用 */
	@PostMapping("calc")
	public String confirmView(@Validated CalcForm form,
			BindingResult bindingResult, Model model) {
		  // 入力チェック
			if (bindingResult.hasErrors()) {
					// 入力チェックNG
					// 入力画面へ
				return "entry";
			}
			// 入力チェックOK
			// 加算実行
			Integer calcResult = form.getLeftNum() + form.getRightNum();
			// Modelに格納する
			model.addAttribute("result", calcResult);
			// 確認画面へ
			return "confirm";
	}
}
