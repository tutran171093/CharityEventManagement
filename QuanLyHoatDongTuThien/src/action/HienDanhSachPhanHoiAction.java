package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import model.bean.PhanHoi;
import model.bo.PhanHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhanHoiForm;

public class HienDanhSachPhanHoiAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhanHoiForm dbForm = (PhanHoiForm) form;

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		// lay danh sach cac khoa

		// lay danh sach sinh vien
		ArrayList<PhanHoi> listPhanHoi;
		PhanHoiBO phanHoiBO = new PhanHoiBO();
		listPhanHoi = phanHoiBO.getDanhSachPhanHoi();
		dbForm.setDanhSachPhanHoi(listPhanHoi);

		// nguoiDungForm.setListSinhVien(listSinhVien);

		return mapping.findForward("danhsachphanhoi");
	}
}
