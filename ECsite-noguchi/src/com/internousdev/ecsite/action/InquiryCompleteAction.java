package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.InquiryCompleteDAO;
import com.internousdev.ecsite.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport implements SessionAware{

	private String name;

	private String qtype;

	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	private Map<String,Object> session;

	//実行メソッド

	public String execute() {

		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();


		/*InquiryCompleteDAOで定義したinsertメソッドを「実行」
		実行して得られた更新数をcountに代入
		実行するためにインスタンスInquiryCompleteDAOを生み出している*/
		int count = dao.insert(name, qtype, body);

		/*代入したcountが0以上だったらInquiryCompleteDAOのselectメソッドを呼び出して実行
		問い合わせ内容をinquiryDTOListに格納
		session.putでキーをつけて他クラスで使用できるように紐付け*/
		if(count > 0){
			inquiryDTOList = dao.select();
			session.put("inquiryDTOList",inquiryDTOList);

			ret=SUCCESS;
		}
		return ret;
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

	public Map<String,Object>getSession() {
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
