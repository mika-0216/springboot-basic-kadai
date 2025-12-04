package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

//お問い合わせフォーム画面遷移と処理を書く場所
//1入力画面を表示する処理
//2入力内容をチェックして確認画面に進む処理
//3最終送信へ進む処理
@Controller
public class ContactFormController {
	
	//入力画面（お問い合わせフォーム）を表示
	@GetMapping("/form")
	public String form(Model model) {
		//最初に準備しとく 入力されたもの保存する箱
		//画面にフォームを渡す（初回は空）
		if (!model.containsAttribute("contactForm")) {model.addAttribute("contactForm", new ContactForm());
		}
		return "contactFormView";
	}
	//confirm＝確認する	
	//入力内容を確認画面に送る 入力内容確認（confirm）へ進む処理
@PostMapping("/confirm")
public String confirm(RedirectAttributes redirectAttributes,
		 //ContactFormはバリテーションを書く場所
			@Validated ContactForm form, BindingResult result, Model model) {
	
	//バリデーションエラーがある場合 → 入力画面に戻す
	if (result.hasErrors()) {
        redirectAttributes.addFlashAttribute("contactForm", form);
        redirectAttributes.addFlashAttribute(
            BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form),
            result
        );
        return "redirect:/form";
    }
	// エラーなし → 確認画面に値を渡す
	model.addAttribute("contactForm", form);
    return "confirmView";
 }
}


