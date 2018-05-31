package form;

import java.util.ArrayList;


import model.bean.PhanHoi;

import org.apache.struts.action.ActionForm;

public class PhanHoiForm extends ActionForm {
	
	private String maUser,tenDangNhap,noiDung,ngayDang, maFeedback,stt;
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	private ArrayList<PhanHoi> danhSachPhanHoi;
	public String getMaUser() {
		return maUser;
	}
	public void setMaUser(String maUser) {
		this.maUser = maUser;
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
	public String getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getMaFeedback() {
		return maFeedback;
	}
	public void setMaFeedback(String maFeedback) {
		this.maFeedback = maFeedback;
	}
	public ArrayList<PhanHoi> getDanhSachPhanHoi() {
		return danhSachPhanHoi;
	}
	public void setDanhSachPhanHoi(ArrayList<PhanHoi> danhSachPhanHoi) {
		this.danhSachPhanHoi = danhSachPhanHoi;
	}
	
	

}
