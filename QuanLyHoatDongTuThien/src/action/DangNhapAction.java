package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThanhVienBO;

import org.apache.catalina.Session;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;

public class DangNhapAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DangNhapForm dangNhapForm = (DangNhapForm) form;
		String tenDangNhap = dangNhapForm.getTenDangNhap();
		String matKhau = dangNhapForm.getMatKhau();
		if (new ThanhVienBO().dangNhap(tenDangNhap, matKhau)) {
			HttpSession session = request.getSession();
			session.setAttribute("tenDangNhap", tenDangNhap);
		}
		return mapping.findForward("thanhCong");

	}

}
