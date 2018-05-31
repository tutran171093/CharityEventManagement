package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThanhVienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.TrangCaNhanForm;

public class AnhDaiDienTrangCaNhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TrangCaNhanForm trangCaNhanForm = (TrangCaNhanForm) form;
		System.out.println(trangCaNhanForm.getTenDangNhap());
		FormFile anhDaiDien = trangCaNhanForm.getAnhDaiDien();
		String tenDangNhap = trangCaNhanForm.getTenDangNhap();
		// Get the servers upload directory real path name
		String filePath = getServlet().getServletContext().getRealPath("/")
				+ "upload";
		System.out.println(filePath);
		// create the upload folder if not exists
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String fileName = anhDaiDien.getFileName();
		if (!("").equals(fileName)) {

			System.out.println("Server path:" + filePath);
			File newFile = new File(filePath, fileName);

			if (!newFile.exists()) {
				FileOutputStream fos = new FileOutputStream(newFile);
				fos.write(anhDaiDien.getFileData());
				fos.flush();
				fos.close();
			}

			request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
			request.setAttribute("uploadedFileName", newFile.getName());
		}
		System.out.println(filePath + "\\" + fileName);
		String urlHinhAnh = "http://10.133.228.231:8080/QuanLyHoatDongTuThien/upload/"
				+ layfileName(fileName);
		ThanhVienBO thanhVienBO = new ThanhVienBO();
		thanhVienBO.datAnhDaiDien(urlHinhAnh, tenDangNhap);
		return mapping.findForward("thanhCong");
	}

	private String layfileName(String fileName) {
		return fileName.replaceAll(" ", "%20");
	}

}
