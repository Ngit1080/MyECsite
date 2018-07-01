package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;

    private List<BuyItemDTO> buyItemDTOList;

	public String execute() {
		String result = "login";

		if(session.containsKey("id")) {
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("buyItmeDTOList",buyItemDTOList);
			result = SUCCESS;
		}
		return result;
	}

	public List<BuyItemDTO> getBuyItemDTO() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}


	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public Map<String,Object> getSession() {
		return this.session;
	}

}
