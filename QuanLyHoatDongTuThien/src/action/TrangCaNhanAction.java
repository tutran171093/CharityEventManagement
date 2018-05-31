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

public class TrangCaNhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		ThanhVien tv = new ThanhVienBO().getTaiKhoan(tenDangNhap);
		TrangCaNhanForm trangCaNhanForm = (TrangCaNhanForm) form;

		if ("Cập nhật".equals(trangCaNhanForm.getSubmit())) {
			tv.setHoTen(trangCaNhanForm.getHoTen());
			tv.setEmail(trangCaNhanForm.getEmail());
			tv.setNgaySinh(trangCaNhanForm.getNgaySinh());
			tv.setSoCMND(trangCaNhanForm.getCMND());
			tv.setDiaChi(trangCaNhanForm.getDiaChi());
			tv.setNoiCongTac(trangCaNhanForm.getNoiCongTac());
			tv.setNgheNghiep(trangCaNhanForm.getNgheNghiep());
			tv.setSoDT(trangCaNhanForm.getSDT());
			tv.setDiemNangDong(trangCaNhanForm.getDiemNangDong());
			tv.setSoLanToChucThanhCong(trangCaNhanForm
					.getSoLanToChucThanhCong());
			tv.setGioiTinh(trangCaNhanForm.getGioiTinh());
			trangCaNhanForm.setUrlAnhDaiDien(tv.getUrlAnhDaiDien());
			ThanhVienBO a = new ThanhVienBO();
			a.capNhatThanhVien(tenDangNhap, tv);
			return mapping.findForward("thanhCong");
		} else {
			trangCaNhanForm.setHoTen(tv.getHoTen());
			trangCaNhanForm.setEmail(tv.getEmail());
			trangCaNhanForm.setNgaySinh(tv.getNgaySinh());
			trangCaNhanForm.setGioiTinh(tv.getGioiTinh());
			trangCaNhanForm.setCMND(tv.getSoCMND());
			trangCaNhanForm.setDiaChi(tv.getDiaChi());
			trangCaNhanForm.setNoiCongTac(tv.getNoiCongTac());
			trangCaNhanForm.setNgheNghiep(tv.getNgheNghiep());
			trangCaNhanForm.setSDT(tv.getSoDT());
			trangCaNhanForm.setDiemNangDong(tv.getDiemNangDong());
			trangCaNhanForm.setSoLanToChucThanhCong(tv
					.getSoLanToChucThanhCong());
			trangCaNhanForm.setUrlAnhDaiDien(tv.getUrlAnhDaiDien());
			return mapping.findForward("thanhCong");
		}
	}

}
