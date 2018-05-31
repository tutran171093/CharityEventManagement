package form;

import java.util.ArrayList;

import model.bean.BaiDang;
import model.bean.ThanhVien;

import org.apache.struts.action.ActionForm;

public class DanhSachChuyenDiDoanTruongForm extends ActionForm {

	private ArrayList<BaiDang> danhSachBaiDang;
	private ArrayList<ThanhVien> danhSachDoanTruongTieuBieu;

	private String maLeader, tenDoanTruong;

	public String getTenDoanTruong() {
		return tenDoanTruong;
	}

	public void setTenDoanTruong(String tenDoanTruong) {
		this.tenDoanTruong = tenDoanTruong;
	}

	public String getMaLeader() {
		return maLeader;
	}

	public void setMaLeader(String maLeader) {
		this.maLeader = maLeader;
	}

	private ArrayList<String> soTrang;
	private String trangSo;

	private ArrayList<BaiDang> danhSachBaiMoiNhat;

	public ArrayList<BaiDang> getDanhSachBaiMoiNhat() {
		return danhSachBaiMoiNhat;
	}

	public void setDanhSachBaiMoiNhat(ArrayList<BaiDang> danhSachBaiMoiNhat) {
		this.danhSachBaiMoiNhat = danhSachBaiMoiNhat;
	}

	public ArrayList<ThanhVien> getDanhSachDoanTruongTieuBieu() {
		return danhSachDoanTruongTieuBieu;
	}

	public void setDanhSachDoanTruongTieuBieu(
			ArrayList<ThanhVien> danhSachDoanTruongTieuBieu) {
		this.danhSachDoanTruongTieuBieu = danhSachDoanTruongTieuBieu;
	}

	public String getTrangSo() {
		return trangSo;
	}

	public void setTrangSo(String trangSo) {
		this.trangSo = trangSo;
	}

	public ArrayList<String> getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(ArrayList<String> soTrang) {
		this.soTrang = soTrang;
	}

	public ArrayList<BaiDang> getDanhSachBaiDang() {
		return danhSachBaiDang;
	}

	public void setDanhSachBaiDang(ArrayList<BaiDang> danhSachBaiDang) {
		this.danhSachBaiDang = danhSachBaiDang;
	}

}
