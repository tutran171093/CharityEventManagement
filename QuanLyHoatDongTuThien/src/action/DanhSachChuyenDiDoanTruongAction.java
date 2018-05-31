package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bo.BaiDangBO;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachChuyenDiDoanTruongForm;
import form.DanhSachChuyenDiForm;

public class DanhSachChuyenDiDoanTruongAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trangSo = request.getParameter("trangSo");
		String maLeader = request.getParameter("maLeader");

		DanhSachChuyenDiDoanTruongForm danhSachChuyenDiForm = (DanhSachChuyenDiDoanTruongForm) form;
		ArrayList<BaiDang> danhSachChuyenDi = new BaiDangBO()
				.getDanhSachBaiDangDoanTruong(maLeader);

		ArrayList<BaiDang> danhSachChuyenDiTrang = new ArrayList<BaiDang>();

		int tongSoChuyenDi = danhSachChuyenDi.size();

		danhSachChuyenDiForm.setMaLeader(maLeader);
		danhSachChuyenDiForm.setTenDoanTruong(new ThanhVienBO().getTaiKhoan(
				maLeader).getHoTen());

		int soTrang = 0;
		if (tongSoChuyenDi > 0) {

			if (tongSoChuyenDi % 3 == 0)
				soTrang = tongSoChuyenDi / 3;
			else
				soTrang = tongSoChuyenDi / 3 + 1;

			if (trangSo.equals("0"))
				trangSo = "1";
			else if (trangSo.equals(String.valueOf(soTrang + 1)))
				trangSo = String.valueOf(soTrang);
			int batDau = (Integer.parseInt(trangSo) - 1) * 3;
			int ketThuc;
			if (tongSoChuyenDi >= batDau + 3)
				ketThuc = batDau + 3;
			else
				ketThuc = batDau + tongSoChuyenDi % 3;

			for (int i = batDau; i < ketThuc; i++) {
				danhSachChuyenDiTrang.add(danhSachChuyenDi.get(i));
			}

		}

		ArrayList<String> soTrangCollection = new ArrayList<String>();

		for (int i = 1; i <= soTrang; i++) {
			soTrangCollection.add(new String(String.valueOf(i)));
		}

		danhSachChuyenDiForm.setDanhSachBaiDang(danhSachChuyenDiTrang);
		danhSachChuyenDiForm.setDanhSachDoanTruongTieuBieu(new ThanhVienBO()
				.getDanhSachDoanTruongTieuBieu());

		danhSachChuyenDiForm.setDanhSachBaiMoiNhat(danhSachChuyenDiTrang);

		danhSachChuyenDiForm.setSoTrang(soTrangCollection);

		danhSachChuyenDiForm.setTrangSo(trangSo);

		return mapping.findForward("chuyenTiep");

	}

}
