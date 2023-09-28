package com.kirian.reminders.entity.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reminder")
public class Reminder {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private Date date;
private String info;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public Reminder(long id, Date date, String info) {
	super();
	this.id = id;
	this.date = date;
	this.info = info;
}
public Reminder() {

}
}
