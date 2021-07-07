package com.sang.sangsever.dto;

public class StatusTransfer<T> {
	private boolean status;
	private String message;
	private T data;

	private StatusTransfer() {
		this.status = true;
		this.message = "";
		this.data = null;
	}

	public StatusTransfer(boolean status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static <T> StatusTransfer<T> newFailureStatus() {
		StatusTransfer<T> status = new StatusTransfer<>();
		status.status = false;
		return status;
	}

	public static <T> StatusTransfer<T> newSuccessStatus() {
		StatusTransfer<T> status = new StatusTransfer<>();
		status.status = false;
		return status;
	}

	public StatusTransfer<T> changeStatus(boolean status) {
		this.status = status;
		return this;
	}

	public StatusTransfer<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public StatusTransfer<T> setData(T data) {
		this.data = data;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

}
