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

import form.HinhAnhForm;

public class HinhAnhAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trangSo = request.getParameter("trangSo");

		HinhAnhForm hinhAnhForm = (HinhAnhForm) form;

		ArrayList<BaiDang> danhSachChuyenDi = new BaiDangBO()
				.getListBaiDangHoanThanh();
		ArrayList<BaiDang> danhSachChuyenDiTrang = new ArrayList<BaiDang>();

		int tongSoChuyenDi = danhSachChuyenDi.size();
		int soTrang;
		if (tongSoChuyenDi % 12 == 0)
			soTrang = tongSoChuyenDi / 12;
		else
			soTrang = tongSoChuyenDi / 12 + 1;

		if (trangSo.equals("0"))
			trangSo = "1";
		else if (trangSo.equals(String.valueOf(soTrang + 1)))
			trangSo = String.valueOf(soTrang);
		int batDau = (Integer.parseInt(trangSo) - 1) * 12;
		int ketThuc;
		if (tongSoChuyenDi >= batDau + 12)
			ketThuc = batDau + 12;
		else
			ketThuc = batDau + tongSoChuyenDi % 12;
		for (int i = batDau; i < ketThuc; i++) {
			danhSachChuyenDiTrang.add(danhSachChuyenDi.get(i));
		}

		ArrayList<String> soTrangCollection = new ArrayList<String>();

		for (int i = 1; i <= soTrang; i++) {
			soTrangCollection.add(new String(String.valueOf(i)));
		}

		hinhAnhForm.setDanhSachDoanTruongTieuBieu(new ThanhVienBO()
				.getDanhSachDoanTruongTieuBieu());

		hinhAnhForm.setDanhSachBaiDang(danhSachChuyenDiTrang);

		hinhAnhForm.setSoTrang(soTrangCollection);

		hinhAnhForm.setTrangSo(trangSo);

		return mapping.findForward("chuyenTiep");
	}

}
