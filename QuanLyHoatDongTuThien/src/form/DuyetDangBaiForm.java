package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BaiDang;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DuyetDangBaiForm extends ActionForm {

	private ArrayList<BaiDang> danhSachBaiDang;
	
	private String maBaiDang,sapXep;

	public String getSapXep() {
		return sapXep;
	}

	public void setSapXep(String sapXep) {
		this.sapXep = sapXep;
	}

	public String getMaBaiDang() {
		return maBaiDang;
	}

	public void setMaBaiDang(String maBaiDang) {
		this.maBaiDang = maBaiDang;
	}

	public ArrayList<BaiDang> getDanhSachBaiDang() {
		return danhSachBaiDang;
	}

	public void setDanhSachBaiDang(ArrayList<BaiDang> danhSachBaiDang) {
		this.danhSachBaiDang = danhSachBaiDang;
	}
	

}
