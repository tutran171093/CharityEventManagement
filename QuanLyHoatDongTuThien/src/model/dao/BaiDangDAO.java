package model.dao;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import model.bean.BaiDang;
import model.bean.DangKyChuyenDi;
import model.bean.ThanhVien;
import model.bo.DangKyChuyenDiBO;
import model.bo.ThanhVienBO;
import utils.ConfigDB;

public class BaiDangDAO {

	public static void main(String[] args) {
		BaiDangDAO b = new BaiDangDAO();
		b.getSoLuotBinhLuan("1");
	}

	public ArrayList<BaiDang> timKiemChuyenDi(String noiDung) {

		try {

			Statement ps = ConfigDB.moKetNoi().createStatement();

			ResultSet rs2 = ps
					.executeQuery("SELECT * FROM BaiDang WHERE TieuDe LIKE '%"
							+ noiDung + "%' AND TrangThai = 2");
			ArrayList<BaiDang> danhSachBaiDang = new ArrayList<BaiDang>();

			PreparedStatement ps2 = ConfigDB
					.moKetNoi()
					.prepareStatement(
							"SELECT * FROM BaiDang WHERE TieuDe LIKE ? AND TrangThai = 2");
			ps2.setString(1, noiDung + "%");

			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {

				BaiDang baiDang = new BaiDang();
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNgayDi(rs.getString("NgayDi"));
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				danhSachBaiDang.add(baiDang);
			}
			return danhSachBaiDang;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	public ArrayList<BaiDang> getListBaiDang(String sapXep) throws SQLException {
		String SQL_DuyetBai = "";
		if (sapXep == null || sapXep.equals("NgayDi"))
			SQL_DuyetBai = "select * from BaiDang where TrangThai=0 ORDER BY NgayDang DESC";
		else
			SQL_DuyetBai = "select * from BaiDang where TrangThai=0 ORDER BY TenDangNhapLeader ASC";
		PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
				SQL_DuyetBai);
		ResultSet rs = ps.executeQuery();
		ArrayList<BaiDang> list = new ArrayList<BaiDang>();
		BaiDang baiDang;
		int s = 0;
		try {
			while (rs.next()) {
				s++;
				baiDang = new BaiDang();
				baiDang.setSoThuTu(s);
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);

				list.add(baiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public int getSoLuongDangKy(String maBaiDang) {
		try {
			String SQL_SoLuongDangKy = "SELECT * FROM DangKiChuyenDi WHERE MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_SoLuongDangKy);
			ps.setString(1, maBaiDang);
			ResultSet rs = ps.executeQuery();
			int soLuotDangKy = 0;
			while (rs.next()) {
				soLuotDangKy++;
			}

			return soLuotDangKy;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {

		}
	}

	public String getSoLuotBinhLuan(String maBaiDang) {
		try {
			String SQL_SoLuotBinhLuan = "SELECT * FROM BinhLuanBaiDang WHERE MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_SoLuotBinhLuan);
			ps.setString(1, maBaiDang);
			ResultSet rs = ps.executeQuery();
			int soLuotBinhLuan = 0;
			while (rs.next()) {
				soLuotBinhLuan++;
			}
			return String.valueOf(soLuotBinhLuan);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} finally {

		}
	}

	public ArrayList<BaiDang> getDanhSachChuyenDi() {

		try {
			String SQL_DanhSachBaiDang = "SELECT * FROM BaiDang WHERE TrangThai = 1 ORDER BY NgayDi DESC";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DanhSachBaiDang);
			ArrayList<BaiDang> danhSachChuyenDi = new ArrayList<BaiDang>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BaiDang baiDang = new BaiDang();
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setKinhPhiDuKien(rs.getLong("KinhPhiDuKien"));
				baiDang.setDiaDiem(rs.getString("DiaDiem"));
				baiDang.setSoNguoiDuKien(rs.getInt("SoNguoiDuKien"));

				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				baiDang.setTrangThai(rs.getInt("TrangThai"));
				baiDang.setTenChuTaiKhoanLeader(new ThanhVienBO().getTaiKhoan(
						rs.getString("TenDangNhapLeader")).getHoTen());
				baiDang.setSoLuongBinhLuan(getSoLuotBinhLuan(baiDang
						.getMaBaiDang()) + " Bình luận");
				String noiDung = baiDang.getNoiDung();
				if (noiDung.length() < 140)
					baiDang.setNoiDungVanTat(noiDung);
				else
					baiDang.setNoiDungVanTat(noiDung.substring(0, 140) + "...");
				baiDang.setSoNguoiDangKy(getSoLuongDangKy(baiDang
						.getMaBaiDang()));
				danhSachChuyenDi.add(baiDang);

			}

			return danhSachChuyenDi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	public ArrayList<BaiDang> getDanhSachChuyenDiMoiNhat() {

		try {
			String SQL_DanhSachBaiDang = "SELECT TOP 5 * FROM BaiDang WHERE TrangThai = 1 ORDER BY NgayDang DESC";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DanhSachBaiDang);
			ArrayList<BaiDang> danhSachChuyenDi = new ArrayList<BaiDang>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BaiDang baiDang = new BaiDang();
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNgayDi(rs.getString("NgayDi"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setKinhPhiDuKien(rs.getLong("KinhPhiDuKien"));
				baiDang.setDiaDiem(rs.getString("DiaDiem"));
				baiDang.setSoNguoiDuKien(rs.getInt("SoNguoiDuKien"));
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));

				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				baiDang.setTrangThai(rs.getInt("TrangThai"));
				baiDang.setTenChuTaiKhoanLeader(new ThanhVienBO().getTaiKhoan(
						rs.getString("TenDangNhapLeader")).getHoTen());
				baiDang.setSoLuongBinhLuan(getSoLuotBinhLuan(baiDang
						.getMaBaiDang()) + " Bình luận");
				String noiDung = baiDang.getNoiDung();
				if (noiDung.length() < 45)
					baiDang.setNoiDungVanTat(noiDung);
				else
					baiDang.setNoiDungVanTat(noiDung.substring(0, 45) + "...");
				baiDang.setSoNguoiDangKy(getSoLuongDangKy(baiDang
						.getMaBaiDang()));
				danhSachChuyenDi.add(baiDang);
			}

			return danhSachChuyenDi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	public ArrayList<BaiDang> getDanhSachBaiDangDoanTruong(String maLeader) {

		try {
			String SQL_DanhSachBaiDang = "SELECT * FROM BaiDang WHERE TrangThai = 2 AND TenDangNhapLeader = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DanhSachBaiDang);
			ArrayList<BaiDang> danhSachChuyenDi = new ArrayList<BaiDang>();
			System.out.print(maLeader);
			ps.setString(1, maLeader);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BaiDang baiDang = new BaiDang();
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setKinhPhiDuKien(rs.getLong("KinhPhiDuKien"));
				baiDang.setDiaDiem(rs.getString("DiaDiem"));
				baiDang.setSoNguoiDuKien(rs.getInt("SoNguoiDuKien"));

				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				baiDang.setTrangThai(rs.getInt("TrangThai"));
				baiDang.setTenChuTaiKhoanLeader(new ThanhVienBO().getTaiKhoan(
						rs.getString("TenDangNhapLeader")).getHoTen());
				baiDang.setSoLuongBinhLuan(getSoLuotBinhLuan(baiDang
						.getMaBaiDang()) + " Bình luận");
				String noiDung = baiDang.getNoiDung();
				if (noiDung.length() < 140)
					baiDang.setNoiDungVanTat(noiDung);
				else
					baiDang.setNoiDungVanTat(noiDung.substring(0, 140) + "...");
				baiDang.setSoNguoiDangKy(getSoLuongDangKy(baiDang
						.getMaBaiDang()));
				danhSachChuyenDi.add(baiDang);

			}
			return danhSachChuyenDi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}

	}

	public BaiDang getChuyenDi(String maChuyenDi) {

		try {
			String SQL_DanhSachBaiDang = "SELECT * FROM BaiDang WHERE MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_DanhSachBaiDang);
			ps.setString(1, maChuyenDi);
			BaiDang baiDang = new BaiDang();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setNgayDi(rs.getString("NgayDi"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setKinhPhiDuKien(rs.getLong("KinhPhiDuKien"));
				baiDang.setDiaDiem(rs.getString("DiaDiem"));
				baiDang.setSoNguoiDuKien(rs.getInt("SoNguoiDuKien"));
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				baiDang.setTrangThai(rs.getInt("TrangThai"));
				baiDang.setTenChuTaiKhoanLeader(new ThanhVienBO().getTaiKhoan(
						rs.getString("TenDangNhapLeader")).getHoTen());
				baiDang.setSoLuongBinhLuan(getSoLuotBinhLuan(baiDang
						.getMaBaiDang()));
				baiDang.setSoNguoiDangKy(getSoLuongDangKy(baiDang
						.getMaBaiDang()));
			}

			return baiDang;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	// GEt danh sach bai dang hoan thanh

	public ArrayList<BaiDang> getListBaiDangHoanThanh() throws SQLException {
		String SQL_DuyetBai = "select * from BaiDang where TrangThai=2";
		PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
				SQL_DuyetBai);
		ResultSet rs = ps.executeQuery();
		ArrayList<BaiDang> list = new ArrayList<BaiDang>();
		BaiDang baiDang;
		int s = 0;
		try {
			while (rs.next()) {
				s++;
				baiDang = new BaiDang();
				baiDang.setSoThuTu(s);
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				if (rs.getString("TieuDe").length() >= 30) {
					baiDang.setTieuDe(rs.getString("TieuDe").substring(0, 30)
							+ "...");
				} else {
					baiDang.setTieuDe(rs.getString("TieuDe"));
				}

				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				list.add(baiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	// Duyet bai dang

	public ArrayList<BaiDang> getListBaiDang() throws SQLException {
		String SQL_DuyetBai = "select * from BaiDang where TrangThai=0 order by MaBaiDang desc";
		PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
				SQL_DuyetBai);
		ResultSet rs = ps.executeQuery();
		ArrayList<BaiDang> list = new ArrayList<BaiDang>();
		BaiDang baiDang;
		int s = 0;
		try {
			while (rs.next()) {
				s++;
				baiDang = new BaiDang();
				baiDang.setSoThuTu(s);
				baiDang.setMaBaiDang(rs.getString("MaBaiDang"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
				baiDang.setTenDangNhapLeader(rs.getString("TenDangNhapLeader"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}

				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);

				list.add(baiDang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public void XoaDangBai(String maBaiDang) throws SQLException {
		String SQL_XoaBai = String.format(
				"DELETE FROM BaiDang WHERE  MaBaiDang= '%s'", maBaiDang);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaBai);
			ps.execute();
		} catch (Exception ex) {

		} finally {

		}
	}

	public void SuaDangBai(String maBaiDang) {
		String SQL_XoaBai = String.format(
				"UPDATE BaiDang set TrangThai=1 WHERE  MaBaiDang= '%s'",
				maBaiDang);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaBai);
			ps.executeUpdate();
		} catch (Exception ex) {

		} finally {

		}
	}

	public void xacNhanHoanThanh(String maBaiDang) {
		String SQL_XoaBai = String.format(
				"UPDATE BaiDang set TrangThai=2 WHERE  MaBaiDang= '%s'",
				maBaiDang);
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaBai);
			ps.executeUpdate();

			ArrayList<ThanhVien> danhSachThanhVien = new DangKyChuyenDiBO()
					.getDanhSachThanhVienDangKyDi(maBaiDang);

			String SQL = "UPDATE DangKiChuyenDi SET TrangThaiCD = ? WHERE TenDangNhapTVDangKy = ? AND MaBaiDang = ?";
			ps = ConfigDB.moKetNoi().prepareStatement(SQL);

			String SQL_U = "";
			PreparedStatement ps3;
			DangKyChuyenDiBO dk = new DangKyChuyenDiBO();
			for (int i = 0; i < danhSachThanhVien.size(); i++) {
				ThanhVien tv = danhSachThanhVien.get(i);
				if (dk.kiemTraDaXacNhanDi(tv.getTenDangNhap(), maBaiDang)) {
					ps.setInt(1, 1);
					ps.setString(2, tv.getTenDangNhap());
					ps.setString(3, maBaiDang);
					ps.executeUpdate();

					SQL_U = "UPDATE ThanhVien SET DiemNangDong = DiemNangDong + 1 WHERE TenDangNhap = ?";
					ps3 = ConfigDB.moKetNoi().prepareStatement(SQL_U);
					ps3.setString(1, tv.getTenDangNhap());
					ps3.executeUpdate();
				} else {
					SQL_U = "UPDATE ThanhVien SET DiemNangDong = DiemNangDong - 1 WHERE TenDangNhap = ?";
					ps3 = ConfigDB.moKetNoi().prepareStatement(SQL_U);
					ps3.setString(1, tv.getTenDangNhap());
					ps3.executeUpdate();
				}
			}

		} catch (Exception ex) {

		} finally {

		}
	}

	public void xoaChuyenDi(String maBaiDang) {
		String SQL_XoaBai = "DELETE FROM BaiDang WHERE MaBaiDang = ?";
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_XoaBai);
			ps.setString(1, maBaiDang);
			ps.executeUpdate();
		} catch (Exception ex) {

		} finally {

		}
	}

	public BaiDang getThongTinBaiDang(String maBaiDang) {
		// TODO Auto-generated method stub
		String SQL_chitiet = "SELECT * FROM BaiDang WHERE MaBaiDang = ?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(
					SQL_chitiet);
			ps.setString(1, maBaiDang);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BaiDang baiDang = new BaiDang();
		try {
			while (rs.next()) {

				baiDang.setTenDangNhapLeader(rs.getString("tenDangNhapLeader"));
				String ngayDang = rs.getString("NgayDang");

				String element[] = ngayDang.split("-");

				@SuppressWarnings("deprecation")
				Date date = new Date(Integer.parseInt(element[0]),
						Integer.parseInt(element[1]),
						Integer.parseInt(element[2]));

				int thu = date.getDay();
				String ngayDangV = "";
				switch (thu) {
				case 0:
					ngayDangV = "Chủ nhật, ";
					break;
				case 1:
					ngayDangV = "Thứ hai, ";
					break;
				case 2:
					ngayDangV = "Thứ ba, ";
					break;
				case 3:
					ngayDangV = "Thứ tư, ";
					break;
				case 4:
					ngayDangV = "Thứ năm, ";
					break;
				case 5:
					ngayDangV = "Thứ sáu, ";
					break;
				case 6:
					ngayDangV = "Thứ bảy, ";
					break;
				}
				ngayDangV += date.getDate() + " Tháng " + date.getMonth()
						+ ", " + date.getYear();

				baiDang.setNgayDang(ngayDangV);
				baiDang.setNgayDi(rs.getString("NgayDi"));
				baiDang.setDiaDiem(rs.getString("DiaDiem"));
				baiDang.setKinhPhiDuKien(rs.getLong("KinhPhiDuKien"));
				baiDang.setSoNguoiDuKien(rs.getInt("SoNguoiDuKien"));
				baiDang.setNoiDung(rs.getString("NoiDung"));
				baiDang.setUrlHinhAnh(rs.getString("URLHinhAnh"));
				baiDang.setTieuDe(rs.getString("TieuDe"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return baiDang;
	}

	public boolean dangBai(BaiDang baiDang) throws UnsupportedEncodingException {
		String query = "insert into BaiDang(MaBaiDang, TieuDe, NgayDi, NoiDung, KinhPhiDuKien, DiaDiem, SoNguoiDuKien, NgayDang, URLHinhAnh, TenDangNhapLeader, TrangThai) values (?, ?, ?, ?, ?, ?, ?, (SELECT GETDATE () AS CurrentDateTime), ?, ?, 0)";
		try {
			PreparedStatement rst = ConfigDB.moKetNoi().prepareStatement(query);
			String a = new String(baiDang.getDiaDiem().getBytes("8859_1"),
					"UTF-8");
			rst.setString(1, layMaBaiDang());
			rst.setString(2, new String(baiDang.getTieuDe().getBytes("8859_1"),
					"UTF-8"));

			rst.setString(3, baiDang.getNgayDi());
			rst.setString(4, new String(
					baiDang.getNoiDung().getBytes("8859_1"), "UTF-8"));
			rst.setLong(5, baiDang.getKinhPhiDuKien());
			rst.setString(6, new String(
					baiDang.getDiaDiem().getBytes("8859_1"), "UTF-8"));
			rst.setInt(7, baiDang.getSoNguoiDuKien());
			rst.setString(8, baiDang.getUrlHinhAnh());
			rst.setString(9, baiDang.getTenDangNhapLeader());//
			rst.executeUpdate();
			rst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {

		}
		return true;
	}

	public String layMaBaiDang() {
		String maBaiDang = null;
		String query = "select * from BaiDang order by  NgayDang";
		try {
			Statement st = ConfigDB.moKetNoi().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				maBaiDang = rs.getString(1);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return String.valueOf(Long.valueOf(maBaiDang) + 1);
	}

	public ArrayList<BaiDang> layDanhSachBaiDangNoiBat() {
		try {
			BaiDang baiDang;
			ArrayList<BaiDang> danhSachBaiDangNoiBat = new ArrayList<BaiDang>();
			String sql = "select top 10 MaBaiDang, TieuDe, cast(NoiDung as nvarchar (30) ) as noidung, URLHinhAnh from baidang where trangthai = 1 order by MaBaiDang desc";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				baiDang = new BaiDang();
				baiDang.setMaBaiDang(rs.getString(1));
				baiDang.setTieuDe(rs.getString(2));
				baiDang.setNoiDungVanTat(rs.getString(3));
				baiDang.setUrlHinhAnh(rs.getString(4));
				danhSachBaiDangNoiBat.add(baiDang);
			}
			return danhSachBaiDangNoiBat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	public boolean kiemTraDoanTruongChuyenDi(String maDoanTruong,
			String maBaiDang) {

		try {
			String sql = "SELECT * FROM BaiDang WHERE MaBaiDang = ? AND TenDangNhapLeader = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, maBaiDang);
			ps.setString(2, maDoanTruong);
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

	// gui tin phan hoi
	public void guiTinPhanHoi(String maUser, String tinNhan, String tenDangNhap) {
		try {

			String sql = "select top 1 MaFeedback  from FeedBack order by  MaFeedback desc ";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int maFeedback = 0;
			while (rs.next()) {
				maFeedback = Integer.parseInt(rs.getString(1)) + 1;
			}

			String sql2 = "insert into FeedBack (MaFeedback, MaUser, TenDangNhap, NoiDung, NgayDang) values (?, ?, ?, ?, (SELECT GETDATE () AS CurrentDateTime))";
			PreparedStatement ps1 = ConfigDB.moKetNoi().prepareStatement(sql2);
			ps1.setInt(1, maFeedback);
			ps1.setString(2, maUser);
			ps1.setString(3, tenDangNhap);
			ps1.setString(4, new String(tinNhan.getBytes("8859_1"), "UTF-8"));
			ps1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
}
