package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class KiemTraTaiKhoanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String tenDangNhap = request.getParameter("search");

		String result = "";

		if (new ThanhVienBO().kiemTraTrungTaiKhoan(tenDangNhap)) {
			result += "Tài khoản này đã tồn tại";
		}


		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		PW.print(result);
		PW.flush();

		return null;
	}

}
