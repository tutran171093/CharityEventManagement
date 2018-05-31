package model.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

import com.sun.org.apache.regexp.internal.recompile;

import model.bean.BaiDang;
import model.bean.ThanhVien;
import utils.ConfigDB;

public class ThanhVienDAO {

	public boolean dangNhap(String tenDangNhap, String matKhau) {
		try {
			String SQL_ThemTaiKhoan = "SELECT * FROM ThanhVien WHERE TenDangNhap = ? AND MatKhau = ? AND Quyen != 0";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_ThemTaiKhoan);
			String matKhauMH = encryptMD5(matKhau);
			ps.setString(1, tenDangNhap);
			ps.setString(2, matKhauMH);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public static String encryptMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean capNhatDiemNangDong(String tenDangNhap) {

		try {
			String SQL_ThemTaiKhoan = "UPDATE ThanhVien SET DiemNangDong = DiemNangDong + 5, SoLanToChucThanhCong = SoLanToChucThanhCong + 1 WHERE TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_ThemTaiKhoan);
			ps.setString(1, tenDangNhap);
			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public boolean dangKyDoanTruong(String tenDangNhap) {

		try {
			String SQL_ThemTaiKhoan = "UPDATE ThanhVien Set Quyen = 4 WHERE TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_ThemTaiKhoan);
			ps.setString(1, tenDangNhap);
			if (ps.executeUpdate() > 0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public ThanhVien getTaiKhoan(String tenDangNhap) {
		try {
			String SQL_GetTaiKhoan = "SELECT * FROM ThanhVien WHERE TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_GetTaiKhoan);
			ps.setString(1, tenDangNhap);
			ThanhVien tv = new ThanhVien();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tv.setTenDangNhap(rs.getString(1));
				tv.setMatKhau(rs.getString(2));
				tv.setNgayDangKy(rs.getString(3));
				tv.setUrlAnhDaiDien(rs.getString(4));
				tv.setHoTen(rs.getString(5));

				String ngaySinh = rs.getString(6);
				String element[] = ngaySinh.split("-");
				String ngaySinhN = element[1] + "/" + element[2] + "/"
						+ element[0];

				tv.setNgaySinh(ngaySinhN);
				tv.setEmail(rs.getString(7));
				tv.setGioiTinh(rs.getInt(8));
				tv.setSoCMND(rs.getString(9));
				tv.setDiaChi(rs.getString(10));
				tv.setNgheNghiep(rs.getString(11));
				tv.setNoiCongTac(rs.getString("NoiCongTac"));
				tv.setSoDT(rs.getString("SoDT"));
				tv.setDiemNangDong(rs.getInt("DiemNangDong"));
				tv.setQuyen(rs.getInt(15));
				tv.setSoLanToChucThanhCong(rs.getInt("SoLanToChucThanhCong"));
				tv.setSoLanToChucThatBai(rs.getInt("SoLanToChucThatBai"));
				tv.setUrlAnhDaiDien(rs.getString("urlAnhDaiDien"));
			}
			return tv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	public boolean themTaiKhoan(String taiKhoan, String matKhau, String hoTen,
			String ngaySinh, String email) {

		try {
			String SQL_ThemTaiKhoan = "INSERT INTO ThanhVien(TenDangNhap,MatKhau,HoTen,NgaySinh,Email, Quyen, NgayDangKy,urlAnhDaiDien) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_ThemTaiKhoan);
			String matKhauMH = encryptMD5(matKhau);
			ps.setString(1, taiKhoan);
			ps.setString(2, matKhauMH);
			ps.setString(3, new String(hoTen.getBytes("8859_1"), "UTF8"));
			ps.setString(4, ngaySinh);
			ps.setString(5, email);
			ps.setInt(6, 1);

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();

			ps.setString(7, dateFormat.format(date));

			ps.setString(8, "./Wisdom of Life_files/images/none.png");

			if (ps.executeUpdate() > 0)
				return true;
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public ArrayList<ThanhVien> getDanhSachDoanTruongTieuBieu() {
		int i = 0;
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();

		String query = "SELECT TOP 5 * FROM ThanhVien  where quyen = 2 ORDER BY SoLanToChucThanhCong DESC";
		try {
			Statement st = ConfigDB.moKetNoi().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ThanhVien tv = new ThanhVien();
				tv.setSoThuTu(++i);
				tv.setTenDangNhap(rs.getString("TenDangNhap"));
				tv.setHoTen(rs.getString("HoTen"));
				tv.setEmail(rs.getString("Email"));
				tv.setQuyen(rs.getInt("Quyen"));
				tv.setSoLanToChucThanhCong(rs.getInt("SoLanToChucThanhCong"));
				tv.setUrlAnhDaiDien(rs.getString("urlAnhDaiDien"));
				arr.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//
		}
		return arr;
	}

	public ArrayList<ThanhVien> getDsThanhVien() {
		int i = 0;
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();
		ThanhVien tv;
		String query = "select TenDangNhap, HoTen, Email, Quyen from ThanhVien where Quyen <> 3 and Quyen <> 0";
		try {
			Statement st = ConfigDB.moKetNoi().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tv = new ThanhVien();
				tv.setSoThuTu(++i);
				tv.setTenDangNhap(rs.getString("TenDangNhap"));
				tv.setHoTen(rs.getString("HoTen"));
				tv.setEmail(rs.getString("Email"));
				tv.setQuyen(rs.getInt("Quyen"));

				arr.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//
		}
		return arr;
	}

	public void banNick(String tenDangNhap) {
		String query = "update ThanhVien set Quyen = 0 where TenDangNhap = ?";
		try {
			PreparedStatement rst = ConfigDB.moKetNoi().prepareStatement(query);
			rst.setString(1, tenDangNhap);
			rst.execute();
			rst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public ArrayList<ThanhVien> timKiem(String maTimKiem, String timTheo) {
		int i = 0;
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();
		ThanhVien tv;
		String query;
		if ("2".equals(timTheo)) {
			query = "select TenDangNhap, HoTen, Email, Quyen from ThanhVien where Quyen <> 3 and Quyen <> 0 and HoTen like N'%"
					+ maTimKiem + "%'";
		} else {
			query = "select TenDangNhap, HoTen, Email, Quyen from ThanhVien where Quyen <> 3 and Quyen <> 0 and TenDangNhap like '%"
					+ maTimKiem + "%'";
		}

		try {
			Statement st = ConfigDB.moKetNoi().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				tv = new ThanhVien();
				tv.setSoThuTu(++i);
				tv.setTenDangNhap(rs.getString(1));
				tv.setHoTen(rs.getString(2));
				tv.setEmail(rs.getString(3));
				tv.setQuyen(Integer.valueOf(rs.getString(4)));
				arr.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public void thayDoiChucVu(String tenDangNhap) {
		String query = "update ThanhVien set Quyen = 3 - Quyen where TenDangNhap = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, tenDangNhap);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	// Ham duyet doan truong
	public ArrayList<ThanhVien> getListThanhVien() {

		String SQL_DoanTruong = "SELECT * FROM ThanhVien WHERE Quyen =4";
		ResultSet rs = null;
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DoanTruong);

			rs = ps.executeQuery();
		} catch (Exception ex) {

		}
		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		ThanhVien thanhVien;
		int s = 0;
		try {
			while (rs.next()) {
				s++;
				thanhVien = new ThanhVien();
				thanhVien.setSoThuTu(s);
				thanhVien.setTenDangNhap(rs.getString("TenDangNhap"));
				thanhVien.setHoTen(rs.getString("HoTen"));

				list.add(thanhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public void xoaDuyetDoanTruong(String tenDangNhap) {
		String SQL_XoaDuyetDoanTruong = String.format(
				"UPDATE ThanhVien set Quyen=1 WHERE  TenDangNhap= '%s'",
				tenDangNhap);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaDuyetDoanTruong);
			ps.executeUpdate();
		} catch (Exception ex) {

		} finally {

		}

	}

	public void DuyetDoanTruong(String tenDangNhap) {
		String SQL_DuyetDoanTruong = String.format(
				"UPDATE ThanhVien set Quyen=2 WHERE  TenDangNhap= '%s'",
				tenDangNhap);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DuyetDoanTruong);
			ps.executeUpdate();
		} catch (Exception ex) {

		} finally {

		}

	}

	public boolean kiemTraTrungTaiKhoan(String tenDangNhap) {

		try {
			String sql_kiemTraTaiKhoan = "SELECT * FROM ThanhVien WHERE TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					sql_kiemTraTaiKhoan);
			ps.setString(1, tenDangNhap);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}

	}

	// Doi mat khau
	public boolean kiemTraTaiKhoan(String tenDangNhap, String matKhau) {
		try {
			String sql_kiemTraTaiKhoan = "SELECT * FROM ThanhVien WHERE TenDangNhap = ? AND MatKhau = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					sql_kiemTraTaiKhoan);
			String matKhauMH = encryptMD5(matKhau);
			ps.setString(1, tenDangNhap);
			ps.setString(2, matKhauMH);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}

			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public boolean doiMatKhau(String tenDangNhap, String matKhauMoi) {
		try {

			String sql = "update ThanhVien set MatKhau = ? where TenDangNhap = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			String matKhauMH = encryptMD5(matKhauMoi);
			ps.setString(1, matKhauMH);
			ps.setString(2, tenDangNhap);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}
	}

	public boolean capNhatThanhVien(String taiKhoan, ThanhVien tv) {
		try {
			String SQL_capNhatThanhVien = "UPDATE ThanhVien SET CMND=?,DiaChi=?,NoiCongTac=?,NgheNghiep=?,SoDT=?, GioiTinh=?,HoTen=?,Email=?,NgaySinh=? WHERE TenDangNhap=?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_capNhatThanhVien);
			ps.setString(1, tv.getSoCMND());
			ps.setString(2, tv.getDiaChi());
			ps.setString(3, tv.getNoiCongTac());
			ps.setString(4, tv.getNgheNghiep());
			ps.setString(5, tv.getSoDT());
			ps.setString(7, tv.getHoTen());
			ps.setString(8, tv.getEmail());
			ps.setString(9, tv.getNgaySinh());
			ps.setString(10, taiKhoan);
			Boolean gioiTinh = false;
			if (tv.getGioiTinh() == 1)
				gioiTinh = true;
			ps.setBoolean(6, gioiTinh);
			if (ps.executeUpdate() > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<ThanhVien> getDanhSachTruongDoan() {
		int i = 0;
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();

		String query = "SELECT tenDangNhap, hoTen, Email FROM ThanhVien where quyen = 2";
		try {
			Statement st = ConfigDB.moKetNoi().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ThanhVien tv = new ThanhVien();
				tv.setSoThuTu(++i);
				tv.setTenDangNhap(rs.getString(1));
				tv.setHoTen(rs.getString(2));
				tv.setEmail(rs.getString(3));
				arr.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//
		}
		return arr;
	}

	public boolean datAnhDaiDien(String urlHinhAnh, String tenDangNhap) {
		System.out.println(urlHinhAnh + "  " + tenDangNhap);
		int flag = 0;
		String query = "update ThanhVien set urlAnhDaiDien = ? where TenDangNhap = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, urlHinhAnh);
			pst.setString(2, tenDangNhap);

			flag = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		if (flag == 1) {
			return true;
		}
		return false;
	}
}
