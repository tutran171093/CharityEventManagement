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

public class SuaDangBaiAction extends Action {
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
		// nhan nut Xac nhan o trang Xoa sinh vien
		BaiDang baiDang = dbBO.getChuyenDi(maBaiDang);
		BaiDangBO.SuaDangBai(maBaiDang);

		new ThongBaoBO()
				.themThongBao(
						baiDang.getTenDangNhapLeader(),
						"Chuyến đi <a href='chiTietBaiDang.do?trangSo=1&maChuyenDi="
								+ baiDang.getMaBaiDang()
								+ "'>"
								+ baiDang.getTieuDe()
								+ "</a> của bạn được sự chấp thuận của quản trị hệ thống!",
						0);

		return mapping.findForward("suaBaiXong");

	}
}