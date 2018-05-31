package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DoiMatKhauForm;

public class DoiMatKhauAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DoiMatKhauForm doiMatKhauForm = (DoiMatKhauForm) form;
		String matKhauCu = doiMatKhauForm.getMatKhauCu();
		String matKhauMoi = doiMatKhauForm.getMatKhauMoi();
		String matKhauXacNhan = doiMatKhauForm.getMatKhauXacNhan();
		HttpSession session = request.getSession();
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();
		if (("".equals(matKhauCu)) || ("".equals(matKhauMoi))
				|| ("".equals(matKhauXacNhan))) {
			doiMatKhauForm.setThongBao("chua nhap");
			return mapping.findForward("thatBai");

		} else if (!(matKhauMoi.equals(matKhauXacNhan))) {
			doiMatKhauForm.setThongBao("mat khau khong khop");
			return mapping.findForward("thatBai");
		} else {
			ThanhVienBO taiKhoanBO = new ThanhVienBO();

			if (taiKhoanBO.kiemTraTaiKhoan(tenDangNhap, matKhauCu)) {
				if (taiKhoanBO.doiMatKhau(tenDangNhap, matKhauMoi)) {
					doiMatKhauForm.setThongBao("doi thanh cong");
					return mapping.findForward("thanhCong");
				} else {
					doiMatKhauForm.setThongBao("loi trang");
					return mapping.findForward("thatBai");
				}
			} else {
				doiMatKhauForm.setThongBao("mat khau sai");
				return mapping.findForward("thatBai");
			}

		}

	}

}
