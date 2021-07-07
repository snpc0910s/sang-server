package com.sang.sangsever.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_stock")
	private Integer idStock;

	@Column(name = "name_stock")
	private String nameStock;

	@Column(name = "name_company")
	private String nameCompany;

	@Column(name = "number_of_buy")
	private Integer numberOfBuy;

	@Column(name = "number_of_sell")
	private Integer numberOfSell;

	@Column(name = "total_sock_of_company")
	private Integer totalSockOfCompany;

	@Column(name = "init_price")
	private Double initPrice;

	@Column(name = "server_status")
	private Integer serverStatus;

	@Column(name = "api_sell")
	private String apiSell;

	@Column(name = "api_buy")
	private String apiBuy;

	@Column(name = "enable")
	private Integer enable;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(Integer idStock, String nameStock, String nameCompany, Integer numberOfBuy, Integer numberOfSell,
			Integer totalSockOfCompany, Double initPrice, Integer serverStatus, String apiSell, String apiBuy,
			Integer enable) {
		super();
		this.idStock = idStock;
		this.nameStock = nameStock;
		this.nameCompany = nameCompany;
		this.numberOfBuy = numberOfBuy;
		this.numberOfSell = numberOfSell;
		this.totalSockOfCompany = totalSockOfCompany;
		this.initPrice = initPrice;
		this.serverStatus = serverStatus;
		this.apiSell = apiSell;
		this.apiBuy = apiBuy;
		this.enable = enable;
	}

	public Integer getIdStock() {
		return idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}

	public String getNameStock() {
		return nameStock;
	}

	public void setNameStock(String nameStock) {
		this.nameStock = nameStock;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public Integer getNumberOfBuy() {
		return numberOfBuy;
	}

	public void setNumberOfBuy(Integer numberOfBuy) {
		this.numberOfBuy = numberOfBuy;
	}

	public Integer getNumberOfSell() {
		return numberOfSell;
	}

	public void setNumberOfSell(Integer numberOfSell) {
		this.numberOfSell = numberOfSell;
	}

	public Integer getTotalSockOfCompany() {
		return totalSockOfCompany;
	}

	public void setTotalSockOfCompany(Integer totalSockOfCompany) {
		this.totalSockOfCompany = totalSockOfCompany;
	}

	public Double getInitPrice() {
		return initPrice;
	}

	public void setInitPrice(Double initPrice) {
		this.initPrice = initPrice;
	}

	public Integer getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(Integer serverStatus) {
		this.serverStatus = serverStatus;
	}

	public String getApiSell() {
		return apiSell;
	}

	public void setApiSell(String apiSell) {
		this.apiSell = apiSell;
	}

	public String getApiBuy() {
		return apiBuy;
	}

	public void setApiBuy(String apiBuy) {
		this.apiBuy = apiBuy;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", nameStock=" + nameStock + ", nameCompany=" + nameCompany
				+ ", numberOfBuy=" + numberOfBuy + ", numberOfSell=" + numberOfSell + ", totalSockOfCompany="
				+ totalSockOfCompany + ", initPrice=" + initPrice + ", serverStatus=" + serverStatus + ", apiSell="
				+ apiSell + ", apiBuy=" + apiBuy + ", enable=" + enable + "]";
	}

}
