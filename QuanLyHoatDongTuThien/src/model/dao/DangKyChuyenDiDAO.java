package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;
import utils.ConfigDB;

public class DangKyChuyenDiDAO {

	public boolean dangKyChuyenDi(String tenDangNhap, String maChuyenDi) {

		try {

			String sql = "INSERT INTO DangKiChuyenDi VALUES(?,?,?,?)";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, maChuyenDi);
			ps.setString(2, tenDangNhap);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			
		}

	}

	public boolean kiemTraDaXacNhanDi(String tenDangNhap, String maBaiDang) {
		try {

			String sql = "SELECT * FROM DangKiChuyenDi WHERE TenDangNhapTVDangKy = ? AND MaBaiDang = ? AND TrangThaiCD = 1";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, tenDangNhap);
			ps.setString(2, maBaiDang);
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

	public boolean xacNhanDaDi(String[] tenDangNhap, String maBaiDang) {
		try {

			String sql2 = "UPDATE DangKiChuyenDi SET TrangThaiCD = 0 WHERE MaBaiDang = ?";
			PreparedStatement ps2 = ConfigDB.moKetNoi().prepareStatement(sql2);
			ps2.setString(1, maBaiDang);
			ps2.executeUpdate();

			String sql = "UPDATE DangKiChuyenDi SET TrangThaiCD = 1 WHERE TenDangNhapTVDangKy = ? AND MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);

			for (int i = 0; i < tenDangNhap.length; i++) {
				ps.setString(1, tenDangNhap[i]);
				ps.setString(2, maBaiDang);
				ps.executeUpdate();
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			
		}
	}

	public ArrayList<ThanhVien> getDanhSachThanhVienDangKyDi(String maBaiDang) {

		try {

			String sql = "SELECT * FROM DangKiChuyenDi WHERE MaBaiDang = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, maBaiDang);
			ArrayList<ThanhVien> danhSachThanhVien = new ArrayList<ThanhVien>();
			ResultSet rs = ps.executeQuery();
			ThanhVienBO thanhVienBO = new ThanhVienBO();
			while (rs.next()) {

				danhSachThanhVien.add(thanhVienBO.getTaiKhoan(rs
						.getString("TenDangNhapTVDangKy")));
			}
			return danhSachThanhVien;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}

	}

	public boolean kiemTraDangKy(String tenDangNhap, String maChuyenDi) {

		try {

			String sql = "SELECT * FROM DangKiChuyenDi WHERE MaBaiDang = ? AND TenDangNhapTVDangKy = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, maChuyenDi);
			ps.setString(2, tenDangNhap);
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

	public boolean huyDangKyChuyenDi(String tenDangNhap, String maChuyenDi) {
		try {

			String sql = "DELETE FROM DangKiChuyenDi WHERE MaBaiDang = ? AND TenDangNhapTVDangKy = ?";
			PreparedStatement ps = ConfigDB.moKetNoi().prepareStatement(sql);
			ps.setString(1, maChuyenDi);
			ps.setString(2, tenDangNhap);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			
		}
	}

	public boolean dieuKienDuocVote(String maChuyenDi, String tenDangNhap) {
		String query = "select TrangThaiCD from DangKiChuyenDi where MaBaiDang = ? and TenDangNhapTVDangKy = ?";
		int trangThaiCD = 0;

		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maChuyenDi);
			pst.setString(2, tenDangNhap);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				trangThaiCD = rs.getInt(1);
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (trangThaiCD == 1) {
			return true;
		}
		return false;
	}

	public boolean voteChuyenDi(String tenDangNhap, String maChuyenDi,
			String vote) {
		boolean flag = false;
		String query = "update DangKiChuyenDi set Vote = ? where TenDangNhapTVDangKy = ? and MaBaiDang = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, vote);
			pst.setString(2, tenDangNhap);
			pst.setString(3, maChuyenDi);
			if (pst.executeUpdate() != 0)
				flag = true;
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return flag;
	}

	public int voteYes(String maChuyenDi) {
		int num = 0;
		String query = "select COUNT(TenDangNhapTVDangKy) from DangKiChuyenDi where MaBaiDang = ? and Vote = 1";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maChuyenDi);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				num = Integer.valueOf(rs.getString(1));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return num;
	}

	public int voteNo(String maChuyenDi) {
		int num = 0;
		String query = "select COUNT(TenDangNhapTVDangKy) from DangKiChuyenDi where MaBaiDang = ? and Vote = 2";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maChuyenDi);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				num = Integer.valueOf(rs.getString(1));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return num;
	}
	
	public ArrayList<ThanhVien> getDanhSachThanhVienVoteTot(String maBaiDang, String tenDangNhap) {
		if(tenDangNhap == null)
			tenDangNhap = "";
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();
		ThanhVien tv;
		String query = "select ThanhVien.HoTen, TenDangNhap from DangKiChuyenDi join ThanhVien on DangKiChuyenDi.TenDangNhapTVDangKy = ThanhVien.TenDangNhap where MaBaiDang = ? and Vote = 1 and TenDangNhap <> ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maBaiDang);
			pst.setString(2, tenDangNhap);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				tv = new ThanhVien();
				tv.setHoTen(rs.getString(1));
				tv.setTenDangNhap(rs.getString(2));
				arr.add(tv);
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConfigDB.moKetNoi();
		}		
		return arr;
	}

	public ArrayList<ThanhVien> getDanhSachThanhVienVoteKhongTot(
			String maBaiDang, String tenDangNhap) {
		if(tenDangNhap == null)
			tenDangNhap = "";
		ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();
		ThanhVien tv;
		String query = "select ThanhVien.HoTen, TenDangNhap from DangKiChuyenDi join ThanhVien on DangKiChuyenDi.TenDangNhapTVDangKy = ThanhVien.TenDangNhap where MaBaiDang = ? and Vote = 2 and TenDangNhap <> ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, maBaiDang);
			pst.setString(2, tenDangNhap);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				tv = new ThanhVien();
				tv.setHoTen(rs.getString(1));
				tv.setTenDangNhap(rs.getString(2));
				arr.add(tv);
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConfigDB.moKetNoi();
		}		
		return arr;
	}
	
	public int banDaVote(String tenDangNhap, String maChuyenDi) {
		int vote = 0;
		String query = "select Vote from DangKiChuyenDi where TenDangNhapTVDangKy = ? and MaBaiDang = ?";
		try {
			PreparedStatement pst = ConfigDB.moKetNoi().prepareStatement(query);
			pst.setString(1, tenDangNhap);
			pst.setString(2, maChuyenDi);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				vote = Integer.valueOf(rs.getString(1));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return vote;
	}

}
