package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;


	private ArrayList<BuyItemDTO> buyItemDTOList  = new ArrayList<BuyItemDTO>();

	//商品購入情報登録メソッド
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		String result = ERROR;

		buyItemDTOList = (ArrayList<BuyItemDTO>) session.get("list");

		//BuyItemActionの"list"の値を取得
		for(int i = 0; i<buyItemDTOList.size(); i++){

			int id = buyItemDTOList.get(i).getId();

			int total_price = buyItemDTOList.get(i).getTotal_price();

			int count = buyItemDTOList.get(i).getCount();

		//BuyItemCompleteDAOで定義したメソッドを使用
        BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

		buyItemCompleteDAO.buyItemInfo(
				id,
				session.get("login_user_id").toString(),
				total_price,
				count,
				buyItemDTOList.get(i).getPay());

		result = SUCCESS;
	}

		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
