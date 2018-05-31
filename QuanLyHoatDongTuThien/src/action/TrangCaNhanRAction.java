package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangCaNhanForm;

public class TrangCaNhanRAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TrangCaNhanForm trangCaNhanForm = (TrangCaNhanForm) form;

		HttpSession session = request.getSession();

		

		String tenDangNhap = trangCaNhanForm.getTenDangNhap();

		String tdn = request.getParameter("maLeader");
		if (tdn != null)
			tenDangNhap = tdn;

		ThanhVien thanhVien = new ThanhVien();
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		thanhVien = thanhVienBO.getTaiKhoan(tenDangNhap);
		trangCaNhanForm.setTenDangNhap(tenDangNhap);
		trangCaNhanForm.setHoTen(thanhVien.getHoTen());
		trangCaNhanForm.setEmail(thanhVien.getEmail());
		trangCaNhanForm.setNgaySinh(thanhVien.getNgaySinh());
		trangCaNhanForm.setGioiTinh(thanhVien.getGioiTinh());
		trangCaNhanForm.setCMND(thanhVien.getSoCMND());
		trangCaNhanForm.setDiaChi(thanhVien.getDiaChi());
		trangCaNhanForm.setNoiCongTac(thanhVien.getNoiCongTac());
		trangCaNhanForm.setSDT(thanhVien.getSoDT());
		trangCaNhanForm.setNgheNghiep(thanhVien.getNgheNghiep());
		trangCaNhanForm.setUrlAnhDaiDien(thanhVien.getUrlAnhDaiDien());
		trangCaNhanForm.setDiemNangDong(thanhVien.getDiemNangDong());
		trangCaNhanForm.setSoLanToChucThanhCong(thanhVien
				.getSoLanToChucThanhCong());
		trangCaNhanForm
				.setSoLanToChucThatBai(thanhVien.getSoLanToChucThatBai());
		;
		return mapping.findForward("xemthanhvien");
	}

}
