package model.bean;

public class ThongBao {

	private int maThongBao;
	private String tenDangNhap, noiDung;
	private int trangThai;
	private String ngay;

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public int getMaThongBao() {
		return maThongBao;
	}

	public void setMaThongBao(int maThongBao) {
		this.maThongBao = maThongBao;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
