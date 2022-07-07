package com.example.unknownplaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OTP {
	@Id
	@GeneratedValue
    private int otpid;
    private int userid;
    private String status;
    private int otp;
	public OTP() {
		super();
		// TODO Auto-generated constructor stub
	
	
	}
	@Override
	public String toString() {
		return "OTP [otpid=" + otpid + ", userid=" + userid + ", status=" + status + ", otp=" + otp + "]";
	}
	public int getOtpid() {
		return otpid;
	}
	public void setOtpid(int otpid) {
		this.otpid = otpid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public OTP(int otpid, int userid, String status, int otp) {
		super();
		this.otpid = otpid;
		this.userid = userid;
		this.status = status;
		this.otp = otp;
	}
    
    
}
