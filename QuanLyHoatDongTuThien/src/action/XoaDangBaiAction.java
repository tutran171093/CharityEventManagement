package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bo.BaiDangBO;
import model.bo.ThongBaoBO;
import model.dao.BaiDangDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DuyetDangBaiForm;

public class XoaDangBaiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DuyetDangBaiForm dbForm = (DuyetDangBaiForm) form;

		BaiDangDAO dbBO = new BaiDangDAO();
		// lay danh sach cac khoa

		// xoa sinh vien
		String maBaiDang = dbForm.getMaBaiDang();
		BaiDang baiDang = dbBO.getChuyenDi(maBaiDang);
		// nhan nut Xac nhan o trang Xoa sinh vien
		BaiDangBO.xoaDangBai(maBaiDang);

		new ThongBaoBO()
				.themThongBao(
						baiDang.getTenDangNhapLeader(),
						"Bạn đăng của bạn đã không nhận được sự chấp nhận của quản trị hệ thống. Xin chua buồn cùng bạn!",
						0);

		return mapping.findForward("xoaBaiXong");

	}
}
