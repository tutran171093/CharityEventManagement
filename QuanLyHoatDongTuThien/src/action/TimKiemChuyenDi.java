package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bo.BaiDangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.KiemTraDinhDang;

public class TimKiemChuyenDi extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		String noiDung = request.getParameter("search");

		if (KiemTraDinhDang.kiemTraPhaHoai(noiDung.trim()))
			return null;

		ArrayList<BaiDang> danhSachBaiDang = new BaiDangBO()
				.timKiemChuyenDi(noiDung);

		PrintWriter out = response.getWriter();
		String result = "";
		for (int i = 0; i < danhSachBaiDang.size(); i++) {

			BaiDang baiDang = danhSachBaiDang.get(i);
			result += "<div class='sug'><img height=30 width=30 src='"
					+ baiDang.getUrlHinhAnh()
					+ "'></img><a href='chiTietBaiDangR.do?trangSo=1&maChuyenDi="
					+ baiDang.getMaBaiDang() + "'>" + baiDang.getTieuDe()
					+ "</a></div>";

		}

		System.out.print(result);
		out.print(result);
		return null;
	}

}
