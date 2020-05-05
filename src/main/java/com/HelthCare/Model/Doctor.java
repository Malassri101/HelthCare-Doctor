package com.HelthCare.Model;

public class Doctor {

	public String docID;
	public String docFname;
	public String docSname;
	public String docEmail;
	public String docMobile;
	public String docSpecialization;
	public String docIntime;
	public String docOutime;
	
	@Override
	public String toString() {
		return "Doctor [docID=" + docID + ", docFname=" + docFname + ", docSname=" + docSname + ", docEmail=" + docEmail
				+ ", docMobile=" + docMobile + ", docSpecialization=" + docSpecialization + ", docIntime=" + docIntime
				+ ", docOutime=" + docOutime + "]";
	}
	
	public String getDocIntime() {
		return docIntime;
	}
	public void setDocIntime(String docIntime) {
		this.docIntime = docIntime;
	}
	public String getDocOutime() {
		return docOutime;
	}
	public void setDocOutime(String docOutime) {
		this.docOutime = docOutime;
	}
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public String getDocFname() {
		return docFname;
	}
	public void setDocFname(String docFname) {
		this.docFname = docFname;
	}
	public String getDocSname() {
		return docSname;
	}
	public void setDocSname(String docSname) {
		this.docSname = docSname;
	}
	public String getDocEmail() {
		return docEmail;
	}
	public void setDocEmail(String docEmail) {
		this.docEmail = docEmail;
	}
	public String getDocMobile() {
		return docMobile;
	}
	public void setDocMobile(String docMobile) {
		this.docMobile = docMobile;
	}
	public String getDocSpecialization() {
		return docSpecialization;
	}
	public void setDocSpecialization(String docSpecialization) {
		this.docSpecialization = docSpecialization;
	}

	
}
