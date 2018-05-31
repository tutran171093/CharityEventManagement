package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThanhVienBO;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThanhVienForm;

public class DuyetXongDoanTruongAction extends Action {
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
		dbBO.DuyetDoanTruong(TenDangNhap);
		new ThongBaoBO()
				.themThongBao(
						TenDangNhap,
						"Yêu cầu làm đoàn trưởng của bạn đã được phê duyệt! Kể từ lúc này bạn là đoàn trưởng, và bạn có thể sử dụng chức năng đăng bài để tổ chức các chuyến đi từ thiện!",
						0);
		return mapping.findForward("DuyetDoanTruong");

	}
}
