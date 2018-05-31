package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThanhVienBO;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangKyForm;

public class DangKyAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (getErrors(request) == null || getErrors(request).size() == 0) {
			DangKyForm dangKyForm = (DangKyForm) form;
			String taiKhoan = dangKyForm.getTaiKhoan();
			String matKhau = dangKyForm.getMatKhau();
			String hoTen = dangKyForm.getHoTen();
			String ngaySinh = dangKyForm.getNgaySinh();
			String email = dangKyForm.getEmail();

			try {
				String element[] = ngaySinh.split("/");

				String ngaySinhN = "";

				ngaySinhN += element[0] + "/";
				ngaySinhN += element[1] + "/";
				ngaySinhN += element[2];

				System.out.println(ngaySinhN);

				if (new ThanhVienBO().themTaiKhoan(taiKhoan, matKhau, hoTen,
						ngaySinhN, email)) {
					HttpSession session = request.getSession();
					session.setAttribute("tenDangNhap", taiKhoan);

					new ThongBaoBO().themThongBao(taiKhoan, "Xin chào "+hoTen+", cảm ơn bạn đã đăng ký tham gia cùng chúng tôi. Hãy cùng chúng tôi KẾT NỐI THƯƠNG YÊU!", 0);

					return mapping.findForward("thanhCong");
				}
				return mapping.getInputForward();

			} catch (Exception e) {
				return mapping.getInputForward();
			}

		} else
			return mapping.getInputForward();

	}
}
