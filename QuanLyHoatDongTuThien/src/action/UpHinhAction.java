package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.HinhAnhBO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpHinhAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpHinhAction() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HinhAnhBO hinhAnhBO = new HinhAnhBO();
		String urlHinhAnh = "http://10.133.228.231:8080/QuanLyHoatDongTuThien/upload/";
		HttpSession session = request.getSession();
		String maBaiDang = session.getAttribute("machuyendi").toString();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (isMultipart) {
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// Parse the request
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()) {
						String fileName = item.getName();
						if (0 == fileName.length()) {
							break;
						}
						String root = getServletContext().getRealPath("/");
						File path = new File(root + "/upload");
						if (!path.exists()) {
							boolean status = path.mkdirs();
						}
						File uploadedFile = new File(path + "/" + fileName);
						System.out.println(uploadedFile.getAbsolutePath());
						urlHinhAnh = "http://10.133.228.231:8080/QuanLyHoatDongTuThien/upload/";
						urlHinhAnh += layfileName(fileName);
						hinhAnhBO.upHinh(maBaiDang, urlHinhAnh);
						if (fileName != "")
							item.write(uploadedFile);
						else
							out.println("file not found");
						out.println("<h1>File Uploaded Successfully....:-)</h1>");
					} else {
						String abc = item.getString();
						out.println("<br><br><h1>" + abc + "</h1><br><br>");
					}
				}
			} catch (FileUploadException e) {
				out.println(e);
			} catch (Exception e) {
				out.println(e);
			}
		} else {
			out.println("Not Multipart");
		}

		// RequestDispatcher rd = request
		// .getRequestDispatcher("hinhanhchuyendi.jsp");
		//
		// rd.forward(request, response);
		response.sendRedirect("hinhanhchuyendi.jsp");
	}

	private String layfileName(String fileName) {
		return fileName.replaceAll(" ", "%20");
	}

}