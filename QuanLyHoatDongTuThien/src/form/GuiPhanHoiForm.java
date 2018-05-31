package form;

import org.apache.struts.action.ActionForm;

public class GuiPhanHoiForm extends ActionForm{
	private String tinNhan;
	private String nutSubmit;
	private String hidden;
	
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getTinNhan() {
		return tinNhan;
	}

	public void setTinNhan(String tinNhan) {
		this.tinNhan = tinNhan;
	}

	public String getNutSubmit() {
		return nutSubmit;
	}

	public void setNutSubmit(String nutSubmit) {
		this.nutSubmit = nutSubmit;
	}
	
	

}
