package model.bo;

import java.util.ArrayList;

import model.bean.ThanhVien;
import model.dao.DangKyChuyenDiDAO;

public class DangKyChuyenDiBO {

	public boolean kiemTraDangKy(String tenDangNhap, String maChuyenDi) {

		return new DangKyChuyenDiDAO().kiemTraDangKy(tenDangNhap, maChuyenDi);
	}

	public boolean dangKyChuyenDi(String tenDangNhap, String maChuyenDi) {
		return new DangKyChuyenDiDAO().dangKyChuyenDi(tenDangNhap, maChuyenDi);
	}

	public boolean huyDangKyChuyenDi(String tenDangNhap, String maChuyenDi) {
		return new DangKyChuyenDiDAO().huyDangKyChuyenDi(tenDangNhap,
				maChuyenDi);
	}

	public ArrayList<ThanhVien> getDanhSachThanhVienDangKyDi(String maBaiDang) {
		return new DangKyChuyenDiDAO().getDanhSachThanhVienDangKyDi(maBaiDang);
	}

	public boolean kiemTraDaXacNhanDi(String tenDangNhap, String maBaiDang) {
		return new DangKyChuyenDiDAO().kiemTraDaXacNhanDi(tenDangNhap,
				maBaiDang);
	}

	public boolean xacNhanDaDi(String[] tenDangNhap, String maBaiDang) {
		return new DangKyChuyenDiDAO().xacNhanDaDi(tenDangNhap, maBaiDang);
	}
	

	public boolean dieuKienDuocVote(String maChuyenDi,	String tenDangNhap){
		return new DangKyChuyenDiDAO().dieuKienDuocVote(maChuyenDi, tenDangNhap);
	}
	
	public boolean voteChuyenDi(String tenDangNhap, String maChuyenDi, String vote){
		return new DangKyChuyenDiDAO().voteChuyenDi(tenDangNhap, maChuyenDi, vote);
	}
	
	public int voteYes(String maChuyenDi){
		return new DangKyChuyenDiDAO().voteYes(maChuyenDi);
	}
	
	public int voteNo(String maChuyenDi){
		return new DangKyChuyenDiDAO().voteNo(maChuyenDi);
	}
	

	public int banDaVote(String tenDangNhap, String maChuyenDi) {
		return new DangKyChuyenDiDAO().banDaVote(tenDangNhap, maChuyenDi);
	}
	
	public ArrayList<ThanhVien> getDanhSachThanhVienVoteTot(String maBaiDang, String tenDangNhap) {
		return new DangKyChuyenDiDAO().getDanhSachThanhVienVoteTot(maBaiDang, tenDangNhap);
	}

	public ArrayList<ThanhVien> getDanhSachThanhVienVoteKhongTot(String maBaiDang, String tenDangNhap) {
		return new DangKyChuyenDiDAO().getDanhSachThanhVienVoteKhongTot(maBaiDang, tenDangNhap);
	}
	
}
