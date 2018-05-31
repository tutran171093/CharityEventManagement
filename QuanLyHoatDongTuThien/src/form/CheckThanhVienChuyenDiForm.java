package form;

import org.apache.struts.action.ActionForm;

public class CheckThanhVienChuyenDiForm extends ActionForm {

	private String[] danhSachThanhVien;

	public String[] getDanhSachThanhVien() {
		return danhSachThanhVien;
	}

	public void setDanhSachThanhVien(String[] danhSachThanhVien) {
		this.danhSachThanhVien = danhSachThanhVien;
	}

}
