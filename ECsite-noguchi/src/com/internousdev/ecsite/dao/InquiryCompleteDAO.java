package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.InquiryDTO;
import com.internousdev.ecsite.util.DBConnector;


public class InquiryCompleteDAO {

	//問い合わせデータ取得メソッド

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public List<InquiryDTO> select() {

		//DBに接続

		DBConnector db = new DBConnector();

		Connection con = db.getConnection();

		String sql = "select * from inquiry";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			//DBから取得した値をsetterでInquiryDTOに格納

			while(rs.next()) {

				InquiryDTO dto = new InquiryDTO();

				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));

				inquiryDTOList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inquiryDTOList;
	}


    //問い合わせデータをDBに格納するメソッド

	public int insert(String name,  String qtype, String body){
		int ret = 0;

		DBConnector db = new DBConnector();

		Connection con = db.getConnection();

       //insert文でデータを挿入
		String sql = "insert into inquiry values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, qtype);
			ps.setString(3, body);

            /*DBへ値を追加した回数をiに代入
			  executeUpdate()メソッドで前処理済みのSQL文を実行し，更新行数を返す。*/
			int i = ps.executeUpdate();

            /*DBへ値を保管できたら、保管した件数を表示
			  retに追加した件数を代入*/
			if(i>0) {
				System.out.println(i+"件登録されました");
				ret = i;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

        //DBを閉じるときも例外処理をしておく
		try {
			con.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

}
