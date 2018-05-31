package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiDang;
import model.bean.PhanHoi;

import model.bo.PhanHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiDangForm;
import form.DuyetDangBaiForm;
import form.PhanHoiForm;

public class XoaPhanHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PhanHoiForm dbForm = (PhanHoiForm) form;

		PhanHoiBO dbBO = new PhanHoiBO();
		//lay danh sach cac khoa
	
	
		
		//xoa sinh vien
		String mafb=dbForm.getMaFeedback();
			//nhan nut Xac nhan o trang Xoa sinh vien
		dbBO.xoaPhanHoi(mafb);
			return mapping.findForward("xoaphanhoi");
	
		}
	}

