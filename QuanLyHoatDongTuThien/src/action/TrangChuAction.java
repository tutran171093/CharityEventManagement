package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bo.BaiDangBO;

import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangChuForm;

public class TrangChuAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TrangChuForm trangChuForm = (TrangChuForm) form;
		BaiDangBO taiKhoanBO = new BaiDangBO();
		ArrayList<BaiDang> danhSachBaiDangNoiBat = new ArrayList<BaiDang>();
		danhSachBaiDangNoiBat = taiKhoanBO.layDanhSachBaiDangNoiBat();

		trangChuForm.setDanhSachBaiDangNoiBat(danhSachBaiDangNoiBat);

		trangChuForm.setDanhSachDoanTruongTieuBieu(new ThanhVienBO()
				.getDanhSachDoanTruongTieuBieu());

		//trangChuForm.setBaiDangTop(danhSachBaiDangNoiBat.get(0));

		return mapping.findForward("trangChu");
	}
}
