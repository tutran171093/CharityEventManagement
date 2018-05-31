package model.bo;

import java.util.ArrayList;

import model.bean.ThongBao;
import model.dao.ThongBaoDAO;

public class ThongBaoBO {

	public boolean themThongBao(String tenDangNhap, String noiDung,
			int trangThai) {
		return new ThongBaoDAO().themThongBao(tenDangNhap, noiDung, trangThai);
	}

	public int getSoLuongThongBaoMoi(String tenDangNhap) {
		return new ThongBaoDAO().getSoLuongThongBaoMoi(tenDangNhap);
	}

	public boolean capNhatTrangThai(String tenDangNhap) {
		return new ThongBaoDAO().capNhatTrangThai(tenDangNhap);
	}

	public ArrayList<ThongBao> getDanhSachThongBao(String tenDangNhap) {
		return new ThongBaoDAO().getDanhSachThongBao(tenDangNhap);
	}

	public boolean xoaThongBao(String maThongBao) {
		return new ThongBaoDAO().xoaThongBao(maThongBao);
	}

	public int getSoLuongThongBaoQuanTri() {
		return new ThongBaoDAO().getSoLuongThongBaoQuanTri();
	}

}
