package com.model2.mvc.service.domain;

import java.sql.Date;


//==>ȸ�������� �𵨸�(�߻�ȭ/ĸ��ȭ)�� Bean
public class Product {
	
	///Field
	private String proTranCode;
	private int prodNo; //��ǰ��ȣ
	private String prodName; //��ǰ��
	private String prodDetail; //��ǰ������
	private String manuDate; //��ǰ��������
	private int price; //����
	private String fileName; //��ǰ�̹���	
	private Date regDate; //�������

	/////////////// EL ���� ���� �߰��� Field ///////////
//	private String phone1;
//	private String phone2;
//	private String phone3;

	///Constructor
	public Product(){
	}
	
	///Method 
	public String getProTranCode() {
		return proTranCode;
	}

	public void setProTranCode(String proTranCode) {
		this.proTranCode = proTranCode;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public String getManuDate() {
		return manuDate;
	}

	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	/////////////// EL ���� ���� �߰��� getter Method ///////////
	
	@Override
	public String toString() {
//		return "Product [proTranCode=" + proTranCode + ", prodNo=" + prodNo + ", prodName=" + prodName + ", prodDetail="
//				+ prodDetail + ", manuDate=" + manuDate + ", price=" + price + ", fileName=" + fileName + ", regDate="
//				+ regDate + "]";
		return "ProductVO : [fileName]" + fileName
				+ "[manuDate]" + manuDate+ "[price]" + price + "[prodDetail]" + prodDetail
				+ "[prodName]" + prodName + "[prodNo]" + prodNo;
	}


}