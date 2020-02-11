package com.app.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.generator.IdGenerator;
import com.app.model.CardInfo;
import com.app.util.DbConnUtil;

public class CardPayDao {

	public static String createTx(CardInfo ci) {
		String sql="insert into cardtab values(?,?,?,?,?,?)";
		String id=null;
		try {
			Connection con=DbConnUtil.getConn();
			PreparedStatement pstmt=con.prepareStatement(sql);

			//Gerenate Tx Id
			id=IdGenerator.getTxId();
			//set data
			pstmt.setString(1,id);
			pstmt.setString(2, ci.getCname());
			pstmt.setString(3, ci.getCnum());
			pstmt.setInt(4, ci.getCvv());
			pstmt.setString(5, ci.getExpDate());
			pstmt.setDouble(6, ci.getAmt());

			//execute 
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}





	public static List<CardInfo> viewAllTx() {
		String sql="select * from CARDTAB";
		List<CardInfo> al=null;
		try {
			Connection con=DbConnUtil.getConn();
			PreparedStatement pstmt=con.prepareStatement(sql);

			ResultSet rs=pstmt.executeQuery();

			al=new ArrayList<>();
			while(rs.next()) {
				al.add(
						//onw row-> one object
						new CardInfo(
								rs.getString(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getInt(4), 
								rs.getString(5), 
								rs.getDouble(6)
								)
						);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;
	}






	public static CardInfo getOneTx(String txId) {
		String sql="select * from cardtab where txid=?";  
		CardInfo ci=null;
		try {
			Connection con=DbConnUtil.getConn();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, txId);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) { //if row exist
				ci=new CardInfo(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getDouble(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ci;
	}





}




