package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();


	//商品情報を取得するメソッド

	public List<BuyItemDTO> getBuyItemInfo() {

		//select文で商品情報を抽出
		String sql = "SELECT id, item_name, item_price, item_category, image_file_path FROM item_info_transaction";

		//DBから取得した値をdto（BuyItemDTOをインスタンス化してdtoという変数名にした）という変数に格納

		//予想していない異常により、エラーが発生するような場面で意図的に回避するための処理（try...catch文)
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			/*nextメソッドで次の行に移動
			 次の行がない場合にfalseを返す
			 dtoに格納した値をbuyItemDTOListに格納*/
			 while(resultSet.next()) {

				BuyItemDTO dto = new BuyItemDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getInt("item_price"));
				dto.setItem_category(resultSet.getString("item_category"));
				dto.setImage_file_path(resultSet.getString("image_file_path"));

				buyItemDTOList.add(dto);


			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return buyItemDTOList;
	}

	public List<BuyItemDTO> getBuyItemDTO() {
		return buyItemDTOList;
	}
}
