package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bean.BinhLuanBaiDang;
import model.bo.BaiDangBO;
import model.bo.BinhLuanBaiDangBO;

import org.apache.catalina.Session;
import org.apache.catalina.ssi.SSICommand;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChiTietBaiDangForm;

public class ChiTietBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String maChuyenDi = "";

		HttpSession session = request.getSession();
		if (session.getAttribute("maChuyenDi") != null) {
			maChuyenDi = session.getAttribute("maChuyenDi").toString();
			session.removeAttribute("maChuyenDi");
		} else {
			maChuyenDi = request.getParameter("maChuyenDi");
		}

		String trangSo = request.getParameter("trangSo");

		request.setAttribute("maChuyenDi", maChuyenDi);

		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang = new BinhLuanBaiDangBO()
				.getBinhLuanBaiDang(maChuyenDi);
		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDangTrang = new ArrayList<BinhLuanBaiDang>();

		int tongSoBinhLuan = danhSachBinhLuanBaiDang.size();
		int soTrang;
		if (tongSoBinhLuan % 6 == 0)
			soTrang = tongSoBinhLuan / 6;
		else
			soTrang = tongSoBinhLuan / 6 + 1;

		int batDau = (Integer.parseInt(trangSo) - 1) * 6;
		int ketThuc;
		if (tongSoBinhLuan >= batDau + 6)
			ketThuc = batDau + 6;
		else
			ketThuc = batDau + tongSoBinhLuan % 6;

		for (int i = batDau; i < ketThuc; i++) {
			danhSachBinhLuanBaiDangTrang.add(danhSachBinhLuanBaiDang.get(i));
		}

		ChiTietBaiDangForm chiTietBaiDangForm = (ChiTietBaiDangForm) form;
		BaiDang baiDang = new BaiDangBO().getChuyenDi(maChuyenDi);

		chiTietBaiDangForm.setMaBaiDang(baiDang.getMaBaiDang());

		chiTietBaiDangForm.setTieuDe(baiDang.getTieuDe());
		chiTietBaiDangForm.setTenDangNhapLeader(baiDang.getTenDangNhapLeader());
		chiTietBaiDangForm.setTenChuTaiKhoanLeader(baiDang
				.getTenChuTaiKhoanLeader());
		chiTietBaiDangForm.setNgayDang(baiDang.getNgayDang());
		chiTietBaiDangForm.setSoNguoiDangKyThamGia(baiDang.getSoNguoiDangKy());
		chiTietBaiDangForm.setSoLuongBinhLuan(baiDang.getSoLuongBinhLuan());
		chiTietBaiDangForm.setNoiDung(baiDang.getNoiDung());
		chiTietBaiDangForm.setNgayDi(baiDang.getNgayDi());
		chiTietBaiDangForm.setDiaDiem(baiDang.getDiaDiem());
		chiTietBaiDangForm.setKinhPhiDuKien(baiDang.getKinhPhiDuKien());
		chiTietBaiDangForm.setSoNguoiDuKien(baiDang.getSoNguoiDuKien());
		chiTietBaiDangForm.setUrlHinhAnh(baiDang.getUrlHinhAnh());

		chiTietBaiDangForm
				.setDanhSachBinhLuanBaiDang(danhSachBinhLuanBaiDangTrang);

		ArrayList<String> soTrangCollection = new ArrayList<String>();

		for (int i = 1; i <= soTrang; i++) {
			soTrangCollection.add(new String(String.valueOf(i)));
		}

		chiTietBaiDangForm.setDanhSachChuyenDiMoiNhat(new BaiDangBO()
				.getDanhSachChuyenDiMoiNhat());
		chiTietBaiDangForm.setSoTrang(soTrangCollection);

		chiTietBaiDangForm.setTrangSo(trangSo);

		return mapping.findForward("chuyenTiep");
	}
}
