package form;

import java.util.ArrayList;

import model.bean.ThanhVien;

import org.apache.struts.action.ActionForm;

public class QuanLyTaiKhoanForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int soLuong;
	private String tenDangNhap;
	private String maTimKiem;
	private String timTheo;
	private String quyen1 = "1";
	private String quyen2 = "2";
	private String quyen4 = "4";

	public String getQuyen4() {
		return quyen4;
	}

	public void setQuyen4(String quyen4) {
		this.quyen4 = quyen4;
	}

	private ArrayList<String> soTrang;
	private String trangSo;

	private ArrayList<ThanhVien> dsThanhVien;

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

	public ArrayList<ThanhVien> getDsThanhVien() {
		return dsThanhVien;
	}

	public void setDsThanhVien(ArrayList<ThanhVien> dsThanhVien) {
		this.dsThanhVien = dsThanhVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQuyen1() {
		return quyen1;
	}

	public void setQuyen1(String quyen1) {
		this.quyen1 = quyen1;
	}

	public String getQuyen2() {
		return quyen2;
	}

	public void setQuyen2(String quyen2) {
		this.quyen2 = quyen2;
	}

	public String getTimTheo() {
		return timTheo;
	}

	public void setTimTheo(String timTheo) {
		this.timTheo = timTheo;
	}

	public String getMaTimKiem() {
		return maTimKiem;
	}

	public void setMaTimKiem(String maTimKiem) {
		this.maTimKiem = maTimKiem;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
