package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThanhVienBO;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DuyetDangBaiForm;
import form.ThanhVienForm;

public class XoaDuyetDoanTruongAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		ThanhVienForm dbForm = (ThanhVienForm) form;

		ThanhVienBO dbBO = new ThanhVienBO();
		// lay danh sach cac khoa

		// xoa sinh vien
		String TenDangNhap = dbForm.getTenDangNhap();
		// nhan nut Xac nhan o trang Xoa sinh vien
		dbBO.xoaDuyetDoanTruong(TenDangNhap);
		new ThongBaoBO()
				.themThongBao(
						TenDangNhap,
						"Yêu cầu làm đoàn trưởng của bạn đã bị từ chối! Rất tiếc, chia buồn cùng bạn!",
						0);
		return mapping.findForward("xoaDuyetDoanTruong");

	}
}