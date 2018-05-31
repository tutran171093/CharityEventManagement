package model.bean;

import java.util.Date;

public class BaiDang {

	private String maBaiDang, tieuDe, noiDung, diaDiem, urlHinhAnh,
			tenDangNhapLeader, tenChuTaiKhoanLeader;
	private String ngayDi, ngayDang, soLuongBinhLuan, noiDungVanTat;
	private long kinhPhiDuKien;
	private int soNguoiDuKien, trangThai, soNguoiDangKy;

	private int soThuTu;

	public int getSoThuTu() {
		return soThuTu;
	}

	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}

	public int getSoNguoiDangKy() {
		return soNguoiDangKy;
	}

	public void setSoNguoiDangKy(int soNguoiDangKy) {
		this.soNguoiDangKy = soNguoiDangKy;
	}

	public String getNoiDungVanTat() {
		return noiDungVanTat;
	}

	public void setNoiDungVanTat(String noiDungVanTat) {
		this.noiDungVanTat = noiDungVanTat;
	}

	public BaiDang() {
		super();
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

	public BaiDang(String maBaiDang, String tieuDe, String noiDung,
			String diaDiem, String urlHinhAnh, String tenDangNhapLeader,
			String ngayDi, String ngayDang, long kinhPhiDuKien,
			int soNguoiDuKien, int trangThai) {
		super();
		this.maBaiDang = maBaiDang;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.diaDiem = diaDiem;
		this.urlHinhAnh = urlHinhAnh;
		this.tenDangNhapLeader = tenDangNhapLeader;
		this.ngayDi = ngayDi;
		this.ngayDang = ngayDang;
		this.kinhPhiDuKien = kinhPhiDuKien;
		this.soNguoiDuKien = soNguoiDuKien;
		this.trangThai = trangThai;
	}

	public String getMaBaiDang() {
		return maBaiDang;
	}

	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
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
