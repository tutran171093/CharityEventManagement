package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bo.BaiDangBO;
import model.dao.BaiDangDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DuyetDangBaiForm;

public class DuyetDangBaiAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DuyetDangBaiForm dbForm = (DuyetDangBaiForm) form;

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		// lay danh sach cac khoa

		// lay danh sach sinh vien
		ArrayList<BaiDang> listBaiDang;
		String sapXep = "";
		sapXep = dbForm.getSapXep();
		// sapXep = request.getParameter("sapXep");
		System.out.println(sapXep);

		BaiDangBO dangBaiBO = new BaiDangBO();
		listBaiDang = new BaiDangDAO().getListBaiDang(sapXep);

		dbForm.setDanhSachBaiDang(listBaiDang);

		// nguoiDungForm.setListSinhVien(listSinhVien);

		return mapping.findForward("duyetbai");
	}
}
