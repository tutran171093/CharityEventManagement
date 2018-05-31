package model.bo;

import java.util.ArrayList;

import model.bean.BinhLuanBaiDang;
import model.dao.BinhLuanBaiDangDAO;

public class BinhLuanBaiDangBO {

	public ArrayList<BinhLuanBaiDang> getBinhLuanBaiDang(String maBaiDang) {
		return new BinhLuanBaiDangDAO().getBinhLuanBaiDang(maBaiDang);
	}

	public boolean themBinhLuan(String maBaiDang, String tenDangNhap,
			String noiDung) {
		return new BinhLuanBaiDangDAO().themBinhLuan(maBaiDang, tenDangNhap,
				noiDung);
	}

}
