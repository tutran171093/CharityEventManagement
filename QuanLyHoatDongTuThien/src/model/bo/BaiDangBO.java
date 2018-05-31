package model.bo;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiDang;
import model.dao.BaiDangDAO;
import model.dao.BinhLuanBaiDangDAO;

public class BaiDangBO {

	static BaiDangDAO dangBaiDAO = new BaiDangDAO();

	public ArrayList<BaiDang> getDanhSachChuyenDi() {
		return new BaiDangDAO().getDanhSachChuyenDi();
	}

	public BaiDang getChuyenDi(String maChuyenDi) {
		return new BaiDangDAO().getChuyenDi(maChuyenDi);
	}

	public ArrayList<BaiDang> getListBaiDang() throws SQLException {
		return dangBaiDAO.getListBaiDang();
	}

	public static void xoaDangBai(String maBaiDang) throws SQLException {
		dangBaiDAO.XoaDangBai(maBaiDang);

	}

	public static void SuaDangBai(String maBaiDang) {

		dangBaiDAO.SuaDangBai(maBaiDang);
	}

	public BaiDang getThongTinBaiDang(String maBaiDang) {

		return dangBaiDAO.getThongTinBaiDang(maBaiDang);
	}

	public boolean dangBai(BaiDang baiDang) throws UnsupportedEncodingException {

		BaiDangDAO dangBaiDAO = new BaiDangDAO();
		if ("".equals(baiDang.getTieuDe()) || "".equals(baiDang.getNgayDi())
				|| "".equals(baiDang.getDiaDiem())
				|| "".equals(baiDang.getNoiDung())) {
			return false;
		}
		return dangBaiDAO.dangBai(baiDang);
	}

	public ArrayList<BaiDang> layDanhSachBaiDangNoiBat() {
		return new BaiDangDAO().layDanhSachBaiDangNoiBat();
	}

	public ArrayList<BaiDang> getDanhSachChuyenDiMoiNhat() {
		return new BaiDangDAO().getDanhSachChuyenDiMoiNhat();
	}

	public boolean kiemTraDoanTruongChuyenDi(String maDoanTruong,
			String maBaiDang) {

		return new BaiDangDAO().kiemTraDoanTruongChuyenDi(maDoanTruong,
				maBaiDang);
	}

	public void xacNhanHoanThanh(String maBaiDang) {
		new BaiDangDAO().xacNhanHoanThanh(maBaiDang);
	}

	public void xoaChuyenDi(String maBaiDang) {
		new BaiDangDAO().xoaChuyenDi(maBaiDang);
	}

	public ArrayList<BaiDang> getListBaiDangHoanThanh() throws SQLException {
		return new BaiDangDAO().getListBaiDangHoanThanh();
	}

	public void guiTinPhanHoi(String maUser, String tinNhan, String tenDangNhap) {
		new BaiDangDAO().guiTinPhanHoi(maUser, tinNhan, tenDangNhap);

	}

	public ArrayList<BaiDang> timKiemChuyenDi(String noiDung) {
		return new BaiDangDAO().timKiemChuyenDi(noiDung);
	}

	public ArrayList<BaiDang> getDanhSachBaiDangDoanTruong(String maLeader) {

		return new BaiDangDAO().getDanhSachBaiDangDoanTruong(maLeader);
	}

}
