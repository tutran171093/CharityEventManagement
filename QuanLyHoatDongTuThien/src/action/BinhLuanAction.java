package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bean.BinhLuanBaiDang;
import model.bo.BaiDangBO;
import model.bo.BinhLuanBaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import utils.KiemTraDinhDang;

import form.BinhLuanForm;
import form.ChiTietBaiDangForm;

public class BinhLuanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ChiTietBaiDangForm binhLuanForm = (ChiTietBaiDangForm) form;
		String noiDung = binhLuanForm.getNoiDungBinhLuan();
		System.out.print(noiDung);
		HttpSession session = request.getSession();
		String tenDangNhap = session.getAttribute("tenDangNhap").toString();
		String maBaiDang = request.getParameter("maChuyenDi");

		String trangSo = request.getParameter("trangSo");

		request.setAttribute("maChuyenDi", maBaiDang);

		if (noiDung != null && !noiDung.trim().equals("")
				&& !KiemTraDinhDang.kiemTraPhaHoai(noiDung))
			new BinhLuanBaiDangBO().themBinhLuan(maBaiDang, tenDangNhap,
					noiDung);

		ArrayList<BinhLuanBaiDang> danhSachBinhLuanBaiDang = new BinhLuanBaiDangBO()
				.getBinhLuanBaiDang(maBaiDang);
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

		BaiDang baiDang = new BaiDangBO().getChuyenDi(maBaiDang);

		binhLuanForm.setMaBaiDang(baiDang.getMaBaiDang());
		binhLuanForm.setSoNguoiDangKyThamGia(baiDang.getSoNguoiDangKy());
		binhLuanForm.setTieuDe(baiDang.getTieuDe());
		binhLuanForm.setTenDangNhapLeader(baiDang.getTenDangNhapLeader());
		binhLuanForm.setTenChuTaiKhoanLeader(baiDang.getTenChuTaiKhoanLeader());
		binhLuanForm.setNgayDang(baiDang.getNgayDang());
		binhLuanForm.setSoLuongBinhLuan(baiDang.getSoLuongBinhLuan());
		binhLuanForm.setNoiDung(baiDang.getNoiDung());
		binhLuanForm.setNgayDi(baiDang.getNgayDi());
		binhLuanForm.setDiaDiem(baiDang.getDiaDiem());
		binhLuanForm.setKinhPhiDuKien(baiDang.getKinhPhiDuKien());
		binhLuanForm.setSoNguoiDuKien(baiDang.getSoNguoiDuKien());
		binhLuanForm.setUrlHinhAnh(baiDang.getUrlHinhAnh());

		binhLuanForm.setNoiDungBinhLuan("ABCDEF");

		binhLuanForm.setDanhSachBinhLuanBaiDang(danhSachBinhLuanBaiDangTrang);

		ArrayList<String> soTrangCollection = new ArrayList<String>();

		for (int i = 1; i <= soTrang; i++) {
			soTrangCollection.add(new String(String.valueOf(i)));
		}

		binhLuanForm.setDanhSachChuyenDiMoiNhat(new BaiDangBO()
				.getDanhSachChuyenDiMoiNhat());
		binhLuanForm.setSoTrang(soTrangCollection);

		binhLuanForm.setTrangSo(trangSo);
		

		return mapping.findForward("chuyenTiep");
	}
}
