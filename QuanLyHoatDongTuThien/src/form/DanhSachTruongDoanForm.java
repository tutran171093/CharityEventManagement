package form;

import java.util.ArrayList;

import model.bean.ThanhVien;

import org.apache.struts.action.ActionForm;

public class DanhSachTruongDoanForm  extends ActionForm{
	ArrayList<ThanhVien> danhSachTruongDoan;

	public ArrayList<ThanhVien> getDanhSachTruongDoan() {
		return danhSachTruongDoan;
	}

	public void setDanhSachTruongDoan(ArrayList<ThanhVien> danhSachTruongDoan) {
		this.danhSachTruongDoan = danhSachTruongDoan;
	}
		
}
