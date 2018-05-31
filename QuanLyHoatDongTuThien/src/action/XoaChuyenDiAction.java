package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bean.ThanhVien;
import model.bo.BaiDangBO;
import model.bo.DangKyChuyenDiBO;
import model.bo.ThongBaoBO;
import model.dao.ThongBaoDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class XoaChuyenDiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String maChuyenDi = request.getParameter("maChuyenDi");
		HttpSession session = request.getSession();
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();

		ArrayList<ThanhVien> danhSachThanhVien = new DangKyChuyenDiBO()
				.getDanhSachThanhVienDangKyDi(maChuyenDi);

		BaiDang baiDang = new BaiDangBO().getThongTinBaiDang(maChuyenDi);
		for (int i = 0; i < danhSachThanhVien.size(); i++) {
			ThanhVien tv = danhSachThanhVien.get(i);
			new ThongBaoBO()
					.themThongBao(
							tv.getTenDangNhap(),
							"Chuyến đi "
									+ baiDang.getTieuDe().toUpperCase()
									+ " mà bạn đã đăng ký, đã bị xóa bởi đoàn trưởng hoặc người quản trị!",
							0);
		}
		new ThongBaoBO().themThongBao(baiDang.getTenDangNhapLeader(),
				"Chuyến đi " + baiDang.getTieuDe().toUpperCase()
						+ " mà bạn làm đoàn trưởng đã bị xóa!", 0);

		new ThongBaoDAO()
				.xoaThongBaoTheoBaiDang("chiTietBaiDang.do?trangSo=1&maChuyenDi="
						+ maChuyenDi);

		new BaiDangBO().xoaChuyenDi(maChuyenDi);

		return mapping.findForward("chuyenTiep");
	}

}
