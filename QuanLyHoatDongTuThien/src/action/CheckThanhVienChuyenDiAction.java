package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.DangKyChuyenDiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CheckThanhVienChuyenDiForm;

public class CheckThanhVienChuyenDiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CheckThanhVienChuyenDiForm checkCD = (CheckThanhVienChuyenDiForm) form;

		String danhSachTV[] = request.getParameterValues("danhSachThanhVienN");

		String maBaiDang = request.getParameter("maChuyenDiCheck");

		System.out.print("Ma chuyen di: " + maBaiDang);

		HttpSession session = request.getSession();
		session.setAttribute("maChuyenDi", maBaiDang);
		request.setAttribute("maChuyenDi", maBaiDang);

		new DangKyChuyenDiBO().xacNhanDaDi(danhSachTV, maBaiDang);

		return mapping.findForward("chuyenTiep");
	}

}
