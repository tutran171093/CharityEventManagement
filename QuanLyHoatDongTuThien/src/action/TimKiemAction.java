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

public class TimKiemAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyTaiKhoanForm quanLyTaiKhoanForm = (QuanLyTaiKhoanForm) form;
		String maTimKiem = quanLyTaiKhoanForm.getMaTimKiem();
		String timTheo = quanLyTaiKhoanForm.getTimTheo();
		ThanhVienBO quanLyTaiKhoanBO = new ThanhVienBO();

		HttpSession session = request.getSession();
		session.setAttribute("maTimKiem", maTimKiem);
		session.setAttribute("timTheo", timTheo);

		//String trangSo = request.getParameter("trangSo");
		String trangSo = "1";

		ArrayList<ThanhVien> danhSachThanhVien = quanLyTaiKhoanBO.timKiem(
				maTimKiem, timTheo);

		ArrayList<ThanhVien> danhSachThanhVienTheoTrang = new ArrayList<ThanhVien>();

		int tongSoChuyenDi = danhSachThanhVien.size();
		int soTrang;
		if (tongSoChuyenDi % 7 == 0)
			soTrang = tongSoChuyenDi / 7;
		else
			soTrang = tongSoChuyenDi / 7 + 1;

		int batDau = (Integer.parseInt(trangSo) - 1) * 7;
		int ketThuc;
		if (tongSoChuyenDi >= batDau + 7)
			ketThuc = batDau + 7;
		else
			ketThuc = batDau + tongSoChuyenDi % 7;
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
		System.out.println(trangSo);
		return mapping.findForward("quanlytimkiem");
	}
}
