package com.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "order")
public class OrderDetails {
	@Id
	private int orderId;
	@NotNull(message = "car name should not be empty")
	private String carName;
	@NotNull(message = "carmodel should not be empty")
	private String carModel;
	@NotNull(message = "user name should not be empty")
	private String username;
	@NotNull(message = "date  should not be empty")
	private String date;
	@NotNull(message = "contact no should not be empty")
	@Pattern(regexp = "\\d{10}", message = "Invalid contact details")
	private Long contactno;
	@NotNull(message = "address should not be empty")
	private String address;
	@NotNull(message = "washpackid should not be empty")
	private int washpackId;
	
	

	

	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderId, @NotNull(message = "car name should not be empty") String carName,
			@NotNull(message = "carmodel should not be empty") String carModel,
			@NotNull(message = "user name should not be empty") String username,
			@NotNull(message = "date  should not be empty") String date,
			@NotNull(message = "contact no should not be empty") @Pattern(regexp = "\\d{10}", message = "Invalid contact details") Long contactno,
			@NotNull(message = "address should not be empty") String address,
			@NotNull(message = "washpackid should not be empty") int washpackId) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.carModel = carModel;
		this.username = username;
		this.date = date;
		this.contactno = contactno;
		this.address = address;
		this.washpackId = washpackId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getContactno() {
		return contactno;
	}

	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWashpackId() {
		return washpackId;
	}

	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", username="
				+ username + ", date=" + date + ", contactno=" + contactno + ", address=" + address + ", washpackId="
				+ washpackId + "]";
	}
	

}

