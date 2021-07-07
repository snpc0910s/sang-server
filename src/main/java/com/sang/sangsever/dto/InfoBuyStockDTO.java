package com.sang.sangsever.dto;

public class InfoBuyStockDTO {
	private Integer idUser;
	private Integer idStock;
	private String nameStock;
	private Integer numberOfStock;
	private Double priceOfStock;

	public InfoBuyStockDTO() {
	}

	public InfoBuyStockDTO(Integer idUser, Integer idStock, String nameStock, Integer numberOfStock,
			Double priceOfStock) {
		super();
		this.idUser = idUser;
		this.idStock = idStock;
		this.nameStock = nameStock;
		this.numberOfStock = numberOfStock;
		this.priceOfStock = priceOfStock;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public Integer getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(Integer numberOfStock) {
		this.numberOfStock = numberOfStock;
	}

	public Double getPriceOfStock() {
		return priceOfStock;
	}

	public void setPriceOfStock(Double priceOfStock) {
		this.priceOfStock = priceOfStock;
	}

	@Override
	public String toString() {
		return "InfoBuyStockDTO [idUser=" + idUser + ", idStock=" + idStock + ", nameStock=" + nameStock
				+ ", numberOfStock=" + numberOfStock + ", priceOfStock=" + priceOfStock + "]";
	}

}
