package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bean.ThanhVien;
import model.bo.BaiDangBO;
import model.bo.DangKyChuyenDiBO;
import model.bo.ThongBaoBO;
import model.dao.ThanhVienDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class XacNhanHoanThanhChuyenDiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String maChuyenDi = request.getParameter("maChuyenDi");
		BaiDang baiDang = new BaiDangBO().getChuyenDi(maChuyenDi);
		new BaiDangBO().xacNhanHoanThanh(maChuyenDi);

		ArrayList<ThanhVien> danhSachThanhVien = new DangKyChuyenDiBO()
				.getDanhSachThanhVienDangKyDi(maChuyenDi);

		DangKyChuyenDiBO dkcdBO = new DangKyChuyenDiBO();

		new ThongBaoBO()
				.themThongBao(
						baiDang.getTenDangNhapLeader(),
						"Bạn đã xác nhận hoàn thành chuyến đi <a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
								+ baiDang.getMaBaiDang()
								+ "'>"
								+ baiDang.getTieuDe() + "</a>", 0);

		for (int i = 0; i < danhSachThanhVien.size(); i++) {

			ThanhVien tv = danhSachThanhVien.get(i);
			if (dkcdBO.kiemTraDaXacNhanDi(tv.getTenDangNhap(), maChuyenDi)) {

				new ThongBaoBO()
						.themThongBao(
								tv.getTenDangNhap(),
								"Bạn đã được đoàn trưởng <a href='xemThanhVien.do?tenDangNhap="
										+ baiDang.getTenDangNhapLeader()
										+ "'>"
										+ baiDang.getTenChuTaiKhoanLeader()
										+ "</a> xác nhận hoàn thành chuyến đi <a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
										+ baiDang.getMaBaiDang()
										+ "'>"
										+ baiDang.getTieuDe()
										+ "</a>. Bạn đã được cộng 1 điểm năng động. Chúc mừng bạn!",
								0);
			} else {
				new ThongBaoBO()
						.themThongBao(
								tv.getTenDangNhap(),
								"Bạn đã bị đoàn trưởng <a href='xemThanhVien.do?tenDangNhap="
										+ baiDang.getTenDangNhapLeader()
										+ "'>"
										+ baiDang.getTenChuTaiKhoanLeader()
										+ "</a> xác nhận không hoàn thành chuyến đi <a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
										+ baiDang.getMaBaiDang()
										+ "'>"
										+ baiDang.getTieuDe()
										+ "</a>. Bạn đã bị trừ 1 điểm năng động",
								0);
			}
		}

		new ThanhVienDAO().capNhatDiemNangDong(baiDang.getTenDangNhapLeader());

		new ThongBaoBO()
				.themThongBao(
						baiDang.getTenDangNhapLeader(),
						"Đã xác nhận hoàn thành chuyến đi <a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
								+ baiDang.getMaBaiDang()
								+ "'>"
								+ baiDang.getTieuDe()
								+ "</a>, bạn được cộng 5 điểm năng động. Chúc mừng bạn",
						0);

		new ThongBaoBO()
				.themThongBao(
						"admin",
						"Đoàn trưởng <a href='xemThanhVien.do?tenDangNhap='"
								+ baiDang.getTenDangNhapLeader()
								+ "></a> đã xác nhận hoàn thành chuyến đi <a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
								+ baiDang.getMaBaiDang() + "'>"
								+ baiDang.getTieuDe() + "</a>", 0);

		return mapping.findForward("chuyenTiep");
	}
}
