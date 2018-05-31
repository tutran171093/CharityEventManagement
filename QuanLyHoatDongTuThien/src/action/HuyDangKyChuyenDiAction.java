package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bo.BaiDangBO;
import model.bo.DangKyChuyenDiBO;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HuyDangKyChuyenDiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String maChuyenDi = request.getParameter("maChuyenDi");
		String tenDangNhap = request.getParameter("tenDangNhap");
		BaiDang baiDang = new BaiDangBO().getChuyenDi(maChuyenDi);
		HttpSession session = request.getSession();
		session.setAttribute("maChuyenDi", maChuyenDi);

		new DangKyChuyenDiBO().huyDangKyChuyenDi(tenDangNhap, maChuyenDi);

		new ThongBaoBO()
				.themThongBao(
						tenDangNhap,
						"Bạn đã hủy đăng ký tham gia chuyến đi <a href='chiTietBaiDang.do?trangSo=1&maChuyenDi="
								+ baiDang.getMaBaiDang()
								+ "'>"
								+ baiDang.getTieuDe() + "</a>", 0);

		return mapping.findForward("chuyenTiep");
	}

}
