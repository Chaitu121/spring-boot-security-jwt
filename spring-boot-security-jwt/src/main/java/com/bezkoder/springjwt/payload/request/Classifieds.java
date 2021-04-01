package com.bezkoder.springjwt.payload.request;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(	name = "classifieds")
public class Classifieds { 

	
	
	private String name;
	
	
	public Classifieds() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Classifieds [title=" + title + ", createddate=" + createddate + ", fileName=" + fileName
				+ ", description=" + description + ", banner=" + banner + ", todate=" + todate + ", fromdate="
				+ fromdate + ", picByte=" + Arrays.toString(picByte) + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	private Date createddate;
	@Column(name="file_name")
	private String fileName;
	private String description;
	public Classifieds(String title, Date createddate, String fileName, String description, String banner, Date todate,
			Date fromdate, byte[] picByte) {
		super();
		this.title = title;
		this.createddate = createddate;
		this.fileName = fileName;
		this.description = description;
		this.banner = banner;
		this.todate = todate;
		this.fromdate = fromdate;
		this.picByte = picByte;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private String banner;
	@JsonFormat(pattern="yyyy-MM-dd", shape=Shape.STRING)
	private Date todate;
	@JsonFormat(pattern="yyyy-MM-dd" , shape=Shape.STRING)
	private Date fromdate;
	 //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte")
	private byte[] picByte;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	

}
