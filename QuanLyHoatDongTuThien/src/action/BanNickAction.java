package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyTaiKhoanForm;

public class BanNickAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyTaiKhoanForm quanLyTaiKhoanForm = (QuanLyTaiKhoanForm) form;
		String tenDangNhap = quanLyTaiKhoanForm.getTenDangNhap();
		ThanhVienBO quanLyTaiKhoanBO = new ThanhVienBO();
		quanLyTaiKhoanBO.banNick(tenDangNhap);
		return mapping.findForward("quanlycapnhat");
	}

}
