package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.BaiDang;
import model.bean.ThanhVien;

public class TrangChuForm extends ActionForm {
	ArrayList<BaiDang> danhSachBaiDangNoiBat;

	private BaiDang baiDangTop;

	public BaiDang getBaiDangTop() {
		return baiDangTop;
	}

	public void setBaiDangTop(BaiDang baiDangTop) {
		this.baiDangTop = baiDangTop;
	}

	public ArrayList<BaiDang> getDanhSachBaiDangNoiBat() {
		return danhSachBaiDangNoiBat;
	}

	private ArrayList<ThanhVien> danhSachDoanTruongTieuBieu;

	public ArrayList<ThanhVien> getDanhSachDoanTruongTieuBieu() {
		return danhSachDoanTruongTieuBieu;
	}

	public void setDanhSachDoanTruongTieuBieu(
			ArrayList<ThanhVien> danhSachDoanTruongTieuBieu) {
		this.danhSachDoanTruongTieuBieu = danhSachDoanTruongTieuBieu;
	}

	public void setDanhSachBaiDangNoiBat(
			ArrayList<BaiDang> danhSachBaiDangNoiBat) {
		this.danhSachBaiDangNoiBat = danhSachBaiDangNoiBat;
	}
}
