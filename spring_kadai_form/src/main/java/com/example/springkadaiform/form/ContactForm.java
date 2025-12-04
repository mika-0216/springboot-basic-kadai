package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//❶ HTML から送られてくる入力データを受け取る
//❷ バリデーション（入力チェック）を定義する
//コントローラ → HTML へのデータ受け渡しにも使う
@Data
public class ContactForm {
	
	//ユーザー名 空欄はNG
	@NotBlank(message = "お名前を入力してください。")
	private String name;
	
	//メールアドレス 空欄NG + メールの形式チェック
	@NotBlank(message = "メールアドレスを入力してください。")
	//@Emailはメールの形になっているか確認する
	@Email(message = "メールアドレスの入力形式が正しくありません。")
	private String email;
	//お問い合わせ内容 空欄NG
	@NotBlank(message = "お問い合わせ内容を入力してください。")
	private String message;

}
