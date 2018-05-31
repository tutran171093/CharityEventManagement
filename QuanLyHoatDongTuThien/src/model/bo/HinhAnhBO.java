package model.bo;

import java.util.ArrayList;

import model.bean.BaiDang;
import model.bean.HinhAnh;
import model.dao.HinhAnhDAO;

public class HinhAnhBO {

	public void upHinh(String maBaiDang, String urlHinhAnh) {
		HinhAnhDAO hinhAnhDAO = new HinhAnhDAO();
		hinhAnhDAO.upHinh(maBaiDang, urlHinhAnh);
	}

	public ArrayList<HinhAnh> getDSHinhAnh(String maBaiDang) {
		HinhAnhDAO hinhAnhDAO = new HinhAnhDAO();
		return hinhAnhDAO.getDSHinhAnh(maBaiDang);
	}
	
	public BaiDang getThongTin(String maBaiDang){
		HinhAnhDAO hinhAnhDAO = new HinhAnhDAO();
		return hinhAnhDAO.getThongTin(maBaiDang);
	}
	public String getChucVu(String tenDangNhap){
		HinhAnhDAO hinhAnhDAO = new HinhAnhDAO();
		return hinhAnhDAO.getChucVu(tenDangNhap);
	}

}
