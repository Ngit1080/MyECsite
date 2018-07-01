package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	//ログイン情報を格納
	public Map<String, Object> session;

	//マイページ情報格納DTO
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	//削除フラグ
	private String deleteFlg;

	private String message;

	private List<BuyItemDTO> buyItemDTOList;

	//商品履歴メソッド

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		List<BuyItemDTO> buyItemDTOList = (List<BuyItemDTO>) session.get("list");

		//idが存在していなかったらtrueになる→return ERRORで返す
		if(!session.containsKey("id")) {

			return ERROR;
		}

		//履歴を削除しない場合
		if(deleteFlg == null) {

            if(buyItemDTOList != null){
            	for(int i=0; i<buyItemDTOList.size(); i++){

            		String item_transaction_id = session.get("id").toString();
            		String user_master_id = session.get("login_user_id").toString();

            		//メソッドを使うためのインスタンス
            		MyPageDAO myPageDAO = new MyPageDAO();

            		myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
            		session.put("myPageList", myPageList);
            	}
            }else{

			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
            MyPageDAO myPageDAO = new MyPageDAO();
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
			session.put("myPageList",myPageList);
            }
			Iterator<MyPageDTO> iterator = myPageList.iterator();

			if(!(iterator.hasNext())) {
				myPageList = null;
			}


		} else {
			delete();
		}
		String result = SUCCESS;

		return result;
	}

	//商品履歴を削除する場合
	public void delete() throws SQLException {


		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		MyPageDAO myPageDAO = new MyPageDAO();
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

		if(res > 0) {
			myPageList = null;

			setMessage("商品情報を正しく削除しました。");

		} else if(res == 0) {

			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

