package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ThongBaoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		new ThongBaoBO().capNhatTrangThai(tenDangNhap);

		return mapping.findForward("chuyenTiep");
	}

}
