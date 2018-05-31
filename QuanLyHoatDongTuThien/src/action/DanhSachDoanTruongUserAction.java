package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachTruongDoanForm;

public class DanhSachDoanTruongUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DanhSachTruongDoanForm danhSachTruongDoanForm = (DanhSachTruongDoanForm) form;
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		ArrayList<ThanhVien> danhSachTruongDoan = thanhVienBO
				.getDanhSachTruongDoan();
		danhSachTruongDoanForm.setDanhSachTruongDoan(danhSachTruongDoan);
		System.out.println(danhSachTruongDoan.size());
		return mapping.findForward("danhSachTruongDoan");

	}

}
