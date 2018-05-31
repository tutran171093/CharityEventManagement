package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;
import model.bo.ThongBaoBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangCaNhanForm;

public class DangKyDoanTruongAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		new ThanhVienBO().dangKyDoanTruong(tenDangNhap);

		new ThongBaoBO()
				.themThongBao(
						tenDangNhap,
						"Đăng ký làm đoàn trưởng! Chờ sự phản hồi của quản trị hệ thống.....",
						0);
		
		
		
		ThanhVien tv = new ThanhVienBO().getTaiKhoan(tenDangNhap);
		TrangCaNhanForm trangCaNhanForm = (TrangCaNhanForm) form;

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
		trangCaNhanForm.setSoLanToChucThanhCong(tv.getSoLanToChucThanhCong());
		trangCaNhanForm.setUrlAnhDaiDien(tv.getUrlAnhDaiDien());
		return mapping.findForward("thanhCong");

	}

}
