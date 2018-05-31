package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bean.BinhLuanBaiDang;
import model.bean.HinhAnh;
import model.bo.BaiDangBO;
import model.bo.BinhLuanBaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HienThiAnhTrangAjaxAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String trang = request.getParameter("trang");

		ArrayList<BaiDang> danhSachChuyenDi = new BaiDangBO()
				.getListBaiDangHoanThanh();
		ArrayList<BaiDang> danhSachChuyenDiTrang = new ArrayList<BaiDang>();

		int tongSoBinhLuan = danhSachChuyenDi.size();
		int soTrang;
		if (tongSoBinhLuan % 12 == 0)
			soTrang = tongSoBinhLuan / 12;
		else
			soTrang = tongSoBinhLuan / 12 + 1;

		int batDau = (Integer.parseInt(trang) - 1) * 12;
		int ketThuc;
		if (tongSoBinhLuan >= batDau + 12)
			ketThuc = batDau + 12;
		else
			ketThuc = batDau + tongSoBinhLuan % 12;

		for (int i = batDau; i < ketThuc; i++) {
			danhSachChuyenDiTrang.add(danhSachChuyenDi.get(i));
		}

		String result = "<ul class='ourHolder'>";

		for (int i = 0; i < danhSachChuyenDiTrang.size(); i++) {
			BaiDang baiDang = danhSachChuyenDi.get(i);
			result += "<li class='item backcolrhover'><a href='hinhanhchuyendi.jsp?machuyendi="
					+ baiDang.getMaBaiDang()
					+ "'><img width='225px' height='128px' src='"
					+ baiDang.getUrlHinhAnh()
					+ "' alt=''></a><div class='caption bold'>"
					+ baiDang.getTieuDe() + "</div></li>";
		}

		result += "</ul>";
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter PW = response.getWriter();
		PW.print(result);
		PW.flush();

		return null;
	}

}
