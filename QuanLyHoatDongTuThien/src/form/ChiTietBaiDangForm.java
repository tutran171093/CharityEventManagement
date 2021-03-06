package form;

import java.util.ArrayList;

import model.bean.BaiDang;
import model.bean.BinhLuanBaiDang;

import org.apache.struts.action.ActionForm;

public class ChiTietBaiDangForm extends ActionForm {

	private String tieuDe, noiDung, diaDiem, urlHinhAnh, tenDangNhapLeader,
			tenChuTaiKhoanLeader;
	private String ngayDi, ngayDang, soLuongBinhLuan, noiDungVanTat;
	private long kinhPhiDuKien;
	private int soNguoiDuKien, trangThai, soNguoiDangKyThamGia;

	private ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang;

	private ArrayList<BaiDang> danhSachChuyenDiMoiNhat;

	private ArrayList<String> soTrang;
	private String trangSo;

	private String noiDungBinhLuan;

	private String maBaiDang;

	public ArrayList<BaiDang> getDanhSachChuyenDiMoiNhat() {
		return danhSachChuyenDiMoiNhat;
	}

	public void setDanhSachChuyenDiMoiNhat(
			ArrayList<BaiDang> danhSachChuyenDiMoiNhat) {
		this.danhSachChuyenDiMoiNhat = danhSachChuyenDiMoiNhat;
	}

	public int getSoNguoiDangKyThamGia() {
		return soNguoiDangKyThamGia;
	}

	public void setSoNguoiDangKyThamGia(int soNguoiDangKyThamGia) {
		this.soNguoiDangKyThamGia = soNguoiDangKyThamGia;
	}

	public String getMaBaiDang() {
		return maBaiDang;
	}

	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}

	public String getNoiDungBinhLuan() {
		return noiDungBinhLuan;
	}

	public void setNoiDungBinhLuan(String noiDungBinhLuan) {
		this.noiDungBinhLuan = noiDungBinhLuan;
	}

	public ArrayList<String> getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(ArrayList<String> soTrang) {
		this.soTrang = soTrang;
	}

	public String getTrangSo() {
		return trangSo;
	}

	public void setTrangSo(String trangSo) {
		this.trangSo = trangSo;
	}

	public ArrayList<BinhLuanBaiDang> getDanhSachBinhLuanBaiDang() {
		return danhSachBinhLuanBaiDang;
	}

	public void setDanhSachBinhLuanBaiDang(
			ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang) {
		this.danhSachBinhLuanBaiDang = danhSachBinhLuanBaiDang;
	}

	public String getNoiDungVanTat() {
		return noiDungVanTat;
	}

	public void setNoiDungVanTat(String noiDungVanTat) {
		this.noiDungVanTat = noiDungVanTat;
	}

	public String getTenChuTaiKhoanLeader() {
		return tenChuTaiKhoanLeader;
	}

	public void setTenChuTaiKhoanLeader(String tenChuTaiKhoanLeader) {
		this.tenChuTaiKhoanLeader = tenChuTaiKhoanLeader;
	}

	public String getSoLuongBinhLuan() {
		return soLuongBinhLuan;
	}

	public void setSoLuongBinhLuan(String soLuongBinhLuan) {
		this.soLuongBinhLuan = soLuongBinhLuan;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getUrlHinhAnh() {
		return urlHinhAnh;
	}

	public void setUrlHinhAnh(String urlHinhAnh) {
		this.urlHinhAnh = urlHinhAnh;
	}

	public String getTenDangNhapLeader() {
		return tenDangNhapLeader;
	}

	public void setTenDangNhapLeader(String tenDangNhapLeader) {
		this.tenDangNhapLeader = tenDangNhapLeader;
	}

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public long getKinhPhiDuKien() {
		return kinhPhiDuKien;
	}

	public void setKinhPhiDuKien(long kinhPhiDuKien) {
		this.kinhPhiDuKien = kinhPhiDuKien;
	}

	public int getSoNguoiDuKien() {
		return soNguoiDuKien;
	}

	public void setSoNguoiDuKien(int soNguoiDuKien) {
		this.soNguoiDuKien = soNguoiDuKien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
