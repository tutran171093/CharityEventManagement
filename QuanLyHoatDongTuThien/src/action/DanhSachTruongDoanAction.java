package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachTruongDoanForm;

public class DanhSachTruongDoanAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachTruongDoanForm danhSachTruongDoanForm = (DanhSachTruongDoanForm) form;

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		ThanhVienBO thanhVienBO = new ThanhVienBO();
		ArrayList<ThanhVien> danhSachTruongDoan = thanhVienBO
				.getDanhSachTruongDoan();
		danhSachTruongDoanForm.setDanhSachTruongDoan(danhSachTruongDoan);
		System.out.println(danhSachTruongDoan.size());
		return mapping.findForward("danhSachTruongDoan");
	}
}
