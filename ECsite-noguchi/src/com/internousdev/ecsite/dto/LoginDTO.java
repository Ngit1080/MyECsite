package com.internousdev.ecsite.dto;

public class LoginDTO {

	//ユーザー情報を保管する変数
	private String loginId;            //ログインID
	private String loginPassword;      //パスワード
	private String userName;           //ユーザー名
	private boolean loginFlg = false;  //ログインチェックに使用


	//getter,setter
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}


}
