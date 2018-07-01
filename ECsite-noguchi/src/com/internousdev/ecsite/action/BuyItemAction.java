package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	//商品情報を格納
	public Map<String,Object> session;

	//商品購入個数（複数購入の可能性があるのでList(String)型の変数
	private List<String> count;

	//支払い方法
	private String pay;

	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<>();


	public String execute() {

		System.out.println(count);

		String result = SUCCESS;

		session.put("count", count);

		@SuppressWarnings("unchecked")
		List<BuyItemDTO> list = (List<BuyItemDTO>) session.get("buyItemDTOList");

		//合計金額を計算する
		//変数名をiとする。i<countはsize()メソッドでjspとつながっている
		for(int i=0; i<count.size(); i++){

			BuyItemDTO buyItemDTO = new BuyItemDTO();

			String buyItemName = list.get(i).getItemName();
			session.put("itemName",buyItemName);

			int buyItemPrice = list.get(i).getItemPrice();
			session.put("itemPrice",buyItemPrice);

			int buyItemId = list.get(i).getId();
			session.put("id",buyItemId);


			String image_file_path = list.get(i).getImage_file_path();

			//countはList型変数なのでget(i)で取得してint型に変換
			int intCount = Integer.parseInt(count.get(i));
            int intPrice = list.get(i).getItemPrice();


            //購入個数が0でなかったら実行する
			if(intCount !=0) {


				/*ここのidはbuyItemIdが入っている
				  buyItemIdはObject型なのでint型にキャスト*/
				buyItemDTO.setId((int) session.get("id"));

				buyItemDTO.setItemName(session.get("itemName").toString());

				buyItemDTO.setItemPrice((int) session.get("itemPrice"));

				buyItemDTO.setCount(intCount);

				buyItemDTO.setImage_file_path(image_file_path);


              /*購入個数×金額の結果をbuyItemDTOに格納
                格納したものをtotal_priceというキーにする*/
				buyItemDTO.setTotal_price(intCount * intPrice);
				session.put("total_price",intCount * intPrice);

				//合計額の計算終わり

		//支払い方法の選択
		String payment;
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay",payment);
			buyItemDTO.setPay(payment);
		} else {
			payment = "クレジットカード";
			session.put("pay",payment);
			buyItemDTO.setPay(payment);

		}
		buyItemDTOList.add(buyItemDTO);
		}

		session.put("list",buyItemDTOList);
		}



		/*複数購入したときの合計額を取得
		 listにデータを格納した回数分（購入した数分）
		 total_priceを取得して加算するループ処理*/

		if(buyItemDTOList.size()>1) {
			int totalPrice = 0;
			for(int a = 0; a<buyItemDTOList.size(); a++){
				totalPrice = totalPrice + buyItemDTOList.get(a).getTotal_price();
			}
			session.put("totalPrice", totalPrice);
		}


		return result;
	}



	//getter,setter
	public ArrayList<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(ArrayList<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	public List<String> getCount() {
		return count;
	}

	public void setCount(List<String> count) {
		this.count = count;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
