package com.internousdev.ecsite.dto;

public class BuyItemDTO {

//	商品情報を保管する

	private int id;                 //DBで自動的につけられるid
	private String itemName;        //商品名
	private int itemPrice;          //商品の値段
	private int total_price;        //合計金額
	private String pay;             //支払い
	private int count;              //個数
	private int total_count;        //合計個数
	private String item_category;   //商品カテゴリー
	private String image_file_path; //商品画像


	//getter,setter
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getItem_categorty() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getImage_file_path() {
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path) {
		this.image_file_path  = image_file_path;
	}

}
