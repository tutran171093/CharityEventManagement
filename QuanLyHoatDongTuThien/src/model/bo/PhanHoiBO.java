package model.bo;

import java.util.ArrayList;

import model.bean.PhanHoi;
import model.dao.PhanHoiDAO;

public class PhanHoiBO {
	static PhanHoiDAO pd=new PhanHoiDAO();
	public ArrayList<PhanHoi> getDanhSachPhanHoi() {
		return pd.getDanhSachPhanHoi();
	}
	
	public void xoaPhanHoi(String mafb) {
		pd.xoaPhanHoi(mafb);
		
	}

}
