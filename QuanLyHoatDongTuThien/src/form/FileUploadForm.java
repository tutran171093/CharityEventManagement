package form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormFile hinhAnh;

	public FormFile getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(FormFile hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
}
