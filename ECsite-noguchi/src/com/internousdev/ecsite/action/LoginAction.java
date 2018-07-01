package com.internousdev.ecsite.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;   //ログインID
	private String loginPassword; //パスワード

	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private List<BuyItemDTO> buyItemDTOList;

	//実行メソッド
	public String execute() {

		String result = ERROR;

		/*LoginDAOのメソッドを使用
		 * 取得した値をloginDTOに格納
		 */
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);

		//loginFlgがtrueだったときの処理
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()) {
				result = SUCCESS;

				//アイテム情報を取得
				buyItemDTOList = buyItemDAO.getBuyItemInfo();

				//BuyItemActionで使用する
				session.put("login_user_id",loginDTO.getLoginId());
				session.put("buyItemDTOList",buyItemDTOList);

				return result;
	}
		return result;

}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
