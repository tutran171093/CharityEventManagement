package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DuyetDangBaiForm;
import form.ThanhVienForm;

public class DuyetDoanTruongAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThanhVienForm dbForm = (ThanhVienForm) form;

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		// lay danh sach cac khoa

		// lay danh sach sinh vien
		ArrayList<ThanhVien> danhSachDoanTruong;
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		danhSachDoanTruong = thanhVienBO.getListThanhVien();
		dbForm.setDanhSachDoanTruong(danhSachDoanTruong);

		// nguoiDungForm.setListSinhVien(listSinhVien);

		return mapping.findForward("duyetdoantruong");
	}
}
