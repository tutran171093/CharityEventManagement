package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import utils.ConfigDB;
import model.bean.BaiDang;
import model.bean.BinhLuanBaiDang;
import model.bo.ThanhVienBO;

public class BinhLuanBaiDangDAO {

	public ArrayList<BinhLuanBaiDang> getBinhLuanBaiDang(String maBaiDang) {
		try {
			String SQL_BinhLuanBaiDang = "SELECT * FROM BinhLuanBaiDang WHERE MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_BinhLuanBaiDang);
			ps.setString(1, maBaiDang);
			ArrayList<BinhLuanBaiDang> danhSachBLBD = new ArrayList<BinhLuanBaiDang>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BinhLuanBaiDang binhLuanBaiDang = new BinhLuanBaiDang();

				binhLuanBaiDang.setMaBinhLuan(rs.getString("MaBinhLuan"));
				binhLuanBaiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				binhLuanBaiDang.setTenDangNhap(rs.getString("TenDangNhap"));
				binhLuanBaiDang.setNoiDung(rs.getString("NoiDung"));
				binhLuanBaiDang.setNgayBinhLuan(rs.getString("NgayBinhLuan"));
				binhLuanBaiDang.setNoiDung(rs.getString("NoiDung"));
				binhLuanBaiDang.setUrlHinhAnh(new ThanhVienBO().getTaiKhoan(
						rs.getString("TenDangNhap")).getUrlAnhDaiDien());

				danhSachBLBD.add(binhLuanBaiDang);
			}

			return danhSachBLBD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}
	}

	public boolean themBinhLuan(String maBaiDang, String tenDangNhap,
			String noiDung) {
		try {
			String SQL_ThemBinhLuan = "INSERT INTO BinhLuanBaiDang(MaBaiDang,TenDangNhap,NoiDung,NgayBinhLuan) VALUES(?,?,?,(SELECT GETDATE () AS CurrentDateTime))";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_ThemBinhLuan);
			ps.setString(1, maBaiDang);
			ps.setString(2, tenDangNhap);
			ps.setString(3, new String(noiDung.getBytes("8859_1"),"UTF-8"));
			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			
		}
	}

}
