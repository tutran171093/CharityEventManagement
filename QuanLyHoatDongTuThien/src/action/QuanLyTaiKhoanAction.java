package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ThanhVien;
import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyTaiKhoanForm;

public class QuanLyTaiKhoanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyTaiKhoanForm quanLyTaiKhoanForm = (QuanLyTaiKhoanForm) form;
		ThanhVienBO quanLyTaiKhoanBO = new ThanhVienBO();

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("thatBai");

		session.removeAttribute("maTimKiem");
		session.removeAttribute("timTheo");

		String trangSo = request.getParameter("trangSo");
		ArrayList<ThanhVien> danhSachThanhVien = quanLyTaiKhoanBO
				.getDsThanhVien();
		ArrayList<ThanhVien> danhSachThanhVienTheoTrang = new ArrayList<ThanhVien>();

		int tongSoChuyenDi = quanLyTaiKhoanBO.getDsThanhVien().size();
		int soTrang;
		if (tongSoChuyenDi % 10 == 0)
			soTrang = tongSoChuyenDi / 10;
		else
			soTrang = tongSoChuyenDi / 10 + 1;

		int batDau = (Integer.parseInt(trangSo) - 1) * 10;
		int ketThuc;
		if (tongSoChuyenDi >= batDau + 10)
			ketThuc = batDau + 10;
		else
			ketThuc = batDau + tongSoChuyenDi % 10;
		for (int i = batDau; i < ketThuc; i++) {
			danhSachThanhVienTheoTrang.add(danhSachThanhVien.get(i));
		}

		ArrayList<String> soTrangCollection = new ArrayList<String>();

		for (int i = 1; i <= soTrang; i++) {
			soTrangCollection.add(new String(String.valueOf(i)));
		}

		quanLyTaiKhoanForm.setDsThanhVien(danhSachThanhVienTheoTrang);
		quanLyTaiKhoanForm.setSoTrang(soTrangCollection);
		quanLyTaiKhoanForm.setTrangSo(trangSo);

		return mapping.findForward("quanly");
	}

}
