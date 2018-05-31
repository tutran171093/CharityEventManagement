package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiDang;
import model.bo.BaiDangBO;
import model.bo.ThongBaoBO;
import model.dao.BaiDangDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.BaiDangForm;

public class DangBaiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BaiDang baiDang = new BaiDang();
		BaiDangForm dangBaiForm = (BaiDangForm) form;

		HttpSession session = request.getSession();

		if (session.getAttribute("tenDangNhap") == null) {
			return mapping.findForward("quanly");
		}

		FormFile file = dangBaiForm.getHinhAnh();
		String fileName = "";
		String filePath = getServlet().getServletContext().getRealPath("/")
				+ "upload";
		if (file != null) {
			File folder = new File(filePath);
			if (!folder.exists()) {
				folder.mkdir();
			}
			fileName = file.getFileName();
			if (!("").equals(fileName)) {
				System.out.println("Server path:" + filePath);
				File newFile = new File(filePath, fileName);
				if (!newFile.exists()) {
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(file.getFileData());
					fos.flush();
					fos.close();
				}
				request.setAttribute("uploadedFilePath",
						newFile.getAbsoluteFile());
				request.setAttribute("uploadedFileName", newFile.getName());
			}
		}
		String urlHinhAnh = "";
		if ("".equals(fileName)) {
			urlHinhAnh = "./Wisdom of Life_files/images/4.jpg";
		} else {
			urlHinhAnh = "http://10.133.228.231:8080/QuanLyHoatDongTuThien/upload/"
					+ layfileName(fileName);
		}
		String tieuDe = dangBaiForm.getTieuDe();
		String ngayDi = dangBaiForm.getNgayDi();
		String diaDiem = dangBaiForm.getDiaDiem();
		String kinhPhi = dangBaiForm.getKinhPhiDuKien();
		String soNguoi = dangBaiForm.getSoNguoiDuKien();
		String noiDung = dangBaiForm.getNoiDung();
		baiDang.setUrlHinhAnh(urlHinhAnh);
		baiDang.setTieuDe(tieuDe);
		baiDang.setNgayDi(ngayDi);
		baiDang.setDiaDiem(diaDiem);
		baiDang.setMaBaiDang(new BaiDangDAO().layMaBaiDang());

		baiDang.setTenDangNhapLeader(session.getAttribute("tenDangNhap")
				.toString());
		// baiDang.setUrlHinhAnh(urlHinhAnh);
		try {
			baiDang.setKinhPhiDuKien(Integer.valueOf(kinhPhi));
			baiDang.setSoNguoiDuKien(Integer.valueOf(soNguoi));
		} catch (NumberFormatException e) {
			return mapping.findForward("dangbai");
		}
		baiDang.setNoiDung(noiDung);
		BaiDangBO dangBaiBO = new BaiDangBO();
		if (dangBaiBO.dangBai(baiDang) == true) {
			new ThongBaoBO().themThongBao(baiDang.getTenDangNhapLeader(),
					"Bạn đã đăng chuyến đi <a href='chiTietBaiDang.do?trangSo=1&maChuyenDi="
							+ baiDang.getMaBaiDang()
							+ "'>"
							+ new String(
									baiDang.getTieuDe().getBytes("8859_1"),
									"UTF-8")
							+ "</a>. Chờ sự đồng ý của quản trị hệ thống....",
					0);
			return mapping.findForward("quanly");
		} else {
			return mapping.findForward("dangbai");
		}
	}

	private String layfileName(String fileName) {
		return fileName.replaceAll(" ", "%20");

	}

}
