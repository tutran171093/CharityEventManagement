package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.ThongBao;
import model.bo.BaiDangBO;
import model.bo.PhanHoiBO;
import model.bo.ThanhVienBO;
import utils.ConfigDB;

public class ThongBaoDAO {

	public boolean xoaThongBao(String maThongBao) {

		try {
			String SQL = "DELETE FROM ThongBao WHERE MaThongBao = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, maThongBao);
			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception ex) {
			return false;
		} finally {
		}

	}

	public boolean xoaThongBaoTheoBaiDang(String noiDung) {
		try {
			String SQL = "DELETE FROM ThongBao WHERE NoiDung LIKE ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, "%" + noiDung + "%");
			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception ex) {
			return false;
		} finally {
		}
	}

	public int getSoLuongThongBaoQuanTri() {
		try {
			int soLuong = 0;
			soLuong += new BaiDangBO().getListBaiDang().size();
			soLuong += new PhanHoiBO().getDanhSachPhanHoi().size();
			soLuong += new ThanhVienBO().getListThanhVien().size();
			return soLuong;
		} catch (Exception ex) {
			return 0;
		} finally {
		}

	}

	public boolean themThongBao(String tenDangNhap, String noiDung,
			int trangThai) {
		try {
			String SQL = "INSERT INTO ThongBao(TenDangNhap,NoiDung,TrangThai,Ngay) VALUES(?,?,?,?)";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, tenDangNhap);
			ps.setString(2, noiDung);
			ps.setInt(3, trangThai);

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			ps.setString(4, dateFormat.format(date));

			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception ex) {
			return false;
		} finally {
		}
	}

	public ArrayList<ThongBao> getDanhSachThongBao(String tenDangNhap) {

		try {
			String SQL = "SELECT * FROM ThongBao WHERE TenDangNhap = ? order by Ngay desc";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, tenDangNhap);
			ResultSet rs = ps.executeQuery();
			ArrayList<ThongBao> danhSachThongBao = new ArrayList<ThongBao>();
			while (rs.next()) {
				ThongBao tb = new ThongBao();
				tb.setMaThongBao(rs.getInt("MaThongBao"));
				tb.setTenDangNhap(rs.getString("TenDangNhap"));
				tb.setTrangThai(rs.getInt("TrangThai"));
				tb.setNoiDung(rs.getString("NoiDung"));
				tb.setNgay(rs.getString("Ngay"));
				danhSachThongBao.add(tb);
			}
			return danhSachThongBao;
		} catch (Exception ex) {
			return null;
		} finally {
		}

	}

	public int getSoLuongThongBaoMoi(String tenDangNhap) {
		try {
			String SQL = "SELECT * FROM ThongBao WHERE TenDangNhap = ? AND TrangThai = 0 ";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, tenDangNhap);
			ResultSet rs = ps.executeQuery();
			int soLuong = 0;
			while (rs.next()) {
				soLuong++;
			}
			return soLuong;
		} catch (Exception ex) {
			return 0;
		} finally {
		}
	}

	public boolean capNhatTrangThai(String tenDangNhap) {
		try {
			String SQL = "UPDATE ThongBao SET TrangThai = 1 WHERE TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(SQL);
			ps.setString(1, tenDangNhap);
			ps.executeUpdate();
			return true;
		} catch (Exception ex) {
			return false;
		} finally {
		}
	}

}
