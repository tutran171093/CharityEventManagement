package model.bo;

import java.util.ArrayList;

import model.bean.ThanhVien;
import model.dao.ThanhVienDAO;

public class ThanhVienBO {

	public boolean themTaiKhoan(String taiKhoan, String matKhau, String hoTen,
			String ngaySinh, String email) {
		return new ThanhVienDAO().themTaiKhoan(taiKhoan, matKhau, hoTen,
				ngaySinh, email);
	}

	public ThanhVien getTaiKhoan(String tenDangNhap) {
		return new ThanhVienDAO().getTaiKhoan(tenDangNhap);
	}

	public boolean dangNhap(String tenDangNhap, String matKhau) {
		return new ThanhVienDAO().dangNhap(tenDangNhap, matKhau);
	}

	public ArrayList<ThanhVien> getDsThanhVien() {
		ThanhVienDAO quanLyTaiKhoanDAO = new ThanhVienDAO();
		return quanLyTaiKhoanDAO.getDsThanhVien();
	}

	public void banNick(String tenDangNhap) {
		ThanhVienDAO quanLyTaiKhoanDAO = new ThanhVienDAO();
		quanLyTaiKhoanDAO.banNick(tenDangNhap);
	}

	public ArrayList<ThanhVien> timKiem(String maTimKiem, String timTheo) {
		ThanhVienDAO quanLyTaiKhoanDAO = new ThanhVienDAO();
		return quanLyTaiKhoanDAO.timKiem(maTimKiem, timTheo);
	}

	public void thayDoiChucVu(String tenDangNhap) {
		ThanhVienDAO quanLyTaiKhoanDAO = new ThanhVienDAO();
		quanLyTaiKhoanDAO.thayDoiChucVu(tenDangNhap);
	}

	static ThanhVienDAO thanhVienDAO = new ThanhVienDAO();

	public ArrayList<ThanhVien> getListThanhVien() {
		return thanhVienDAO.getListThanhVien();
	}

	public void xoaDuyetDoanTruong(String tenDangNhap) {
		// TODO Auto-generated method stub
		thanhVienDAO.xoaDuyetDoanTruong(tenDangNhap);
	}

	public void DuyetDoanTruong(String tenDangNhap) {
		thanhVienDAO.DuyetDoanTruong(tenDangNhap);
	}

	// kiem tra tai khoan
	public boolean kiemTraTaiKhoan(String tenDangNhap, String matKhauCu) {
		return new ThanhVienDAO().kiemTraTaiKhoan(tenDangNhap, matKhauCu);
	}

	// doi mat khau
	public boolean doiMatKhau(String tenDangNhap, String matKhauMoi) {
		return new ThanhVienDAO().doiMatKhau(tenDangNhap, matKhauMoi);

	}

	public boolean capNhatThanhVien(String tenDangNhap, ThanhVien tv) {
		return new ThanhVienDAO().capNhatThanhVien(tenDangNhap, tv);
	}

	public ArrayList<ThanhVien> getDanhSachDoanTruongTieuBieu() {
		return new ThanhVienDAO().getDanhSachDoanTruongTieuBieu();
	}

	public ArrayList<ThanhVien> getDanhSachTruongDoan() {
		return new ThanhVienDAO().getDanhSachTruongDoan();
	}

	public boolean datAnhDaiDien(String urlHinhAnh, String tenDangNhap) {
		return new ThanhVienDAO().datAnhDaiDien(urlHinhAnh, tenDangNhap);
	}

	public boolean kiemTraTrungTaiKhoan(String tenDangNhap) {
		return new ThanhVienDAO().kiemTraTrungTaiKhoan(tenDangNhap);
	}

	public boolean dangKyDoanTruong(String tenDangNhap) {
		return new ThanhVienDAO().dangKyDoanTruong(tenDangNhap);
	}

}
