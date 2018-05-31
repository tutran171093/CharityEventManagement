package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConfigDB;
import model.bean.BaiDang;
import model.bean.PhanHoi;



public class PhanHoiDAO {

	public ArrayList<PhanHoi> getDanhSachPhanHoi() {
		ArrayList<PhanHoi> list =  new ArrayList<PhanHoi>();;
		String SQL_PhanHoi = "SELECT * FROM FeedBack";
		ResultSet rs = null;
	try{
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_PhanHoi);
			
			
			rs = ps.executeQuery();}catch(Exception ex){
				
			}
			
			
			int s=0;
			try {
				while (rs.next()) {
					s++;
					
					PhanHoi phanHoi = new PhanHoi();
					phanHoi.setMaFeedback(rs.getString("MaFeedback"));
					phanHoi.setMaUser(rs.getString("MaUser"));
					phanHoi.setTenDangNhap(rs.getString("TenDangNhap"));
					phanHoi.setNoiDung(rs.getString("NoiDung"));
					phanHoi.setNgayDang(rs.getString("NgayDang"));
				phanHoi.setStt(s+"");
					

					list.add(phanHoi);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
			}
			return list;
		}

	
	public void xoaPhanHoi(String mafb) {
		String SQL_XoaPH = String.format(
				"DELETE FROM FeedBack WHERE  MaFeedback= '%s'", mafb);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaPH);
			ps.execute();
		} catch (Exception ex) {

		} finally {
			

		}
		
	}}
		
		
		
		
	


