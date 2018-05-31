package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaiDang;
import model.bean.HinhAnh;
import utils.ConfigDB;

public class HinhAnhDAO {

	public void upHinh(String maBaiDang, String urlHinhAnh) {
		String query = "insert into AnhChuyenDi(MaBaiDang, URL) values(?, ?)";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maBaiDang);
			pst.setString(2, urlHinhAnh);
			System.out.println(maBaiDang + urlHinhAnh);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HinhAnh> getDSHinhAnh(String maBaiDang) {
		HinhAnh hinhAnh;
		ArrayList<HinhAnh> arr = new ArrayList<HinhAnh>();
		String query = "select MaBaiDang, URL from AnhChuyenDi where MaBaiDang = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maBaiDang);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				hinhAnh = new HinhAnh();
				hinhAnh.setMaBaiDang(rs.getString(1));
				hinhAnh.setUrlHinhAnh(rs.getString(2));
				arr.add(hinhAnh);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public BaiDang getThongTin(String maBaiDang) {
		System.out.println("HinhAnhDAO");
		BaiDang baiDang = new BaiDang();
		String query = "select TieuDe, NgayDi, HoTen, TenDangNhapLeader from BaiDang join ThanhVien on BaiDang.TenDangNhapLeader = ThanhVien.TenDangNhap where MaBaiDang = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maBaiDang);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				baiDang.setTieuDe(rs.getString(1));
				baiDang.setNgayDi(rs.getString(2));
				baiDang.setTenChuTaiKhoanLeader(rs.getString(3));
				baiDang.setTenDangNhapLeader(rs.getString(4));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return baiDang;
	}

	public String getChucVu(String tenDangNhap) {
		String chucVu = "";
		String query = "select Quyen from ThanhVien where TenDangNhap = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, tenDangNhap);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				chucVu = rs.getString(1);
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return chucVu;
	}
}
