package com.internousdev.ecsite.dto;

public class InquiryDTO {

	//問い合わせ情報を保管するための変数

	private String name;   // 名前
	private String qtype;  //質問の種類
	private String body;   //内容


	//getter,setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


}
