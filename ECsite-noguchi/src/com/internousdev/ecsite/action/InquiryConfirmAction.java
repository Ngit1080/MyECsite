package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class InquiryConfirmAction extends ActionSupport implements SessionAware {

	private String name;

	private String qtype;

	private String body;

	public Map<String,Object> session;

	private String errorMessage;

	public String execute() {

		String result = ERROR;

		//名前とかつ質問内容が空じゃなかったらsession.putしてSUCCESSを返す
		if(!(name.equals(""))
		        && !(body.equals(""))){

			session.put("name",name);
			session.put("body",body);
			session.put("qtype",qtype);

			result = SUCCESS;
		//名前、質問内容どちらかが空だったらエラー文を出す
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;

		} return result;
	}


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

	public String getERRORMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
