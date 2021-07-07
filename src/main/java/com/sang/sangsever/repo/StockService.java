package com.sang.sangsever.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sang.sangsever.dto.InfoBuyStockDTO;
import com.sang.sangsever.dto.InfoSellStockDTO;
import com.sang.sangsever.dto.StatusTransfer;
import com.sang.sangsever.entity.Stock;

@Service
public class StockService {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private StockRepository stockRepository;

	public List<Stock> findAll() {
		return stockRepository.findAll();
	}

	public Optional<Stock> findStockById(Integer idStock) {
		return stockRepository.findById(idStock);
	}
	public void createStock(Stock stock){
		stock.setIdStock(-1);
		stockRepository.save(stock);
	}
	
	public void updateStock(Stock stock) {
		stockRepository.save(stock);
	}

	public boolean enableStatusStockById(Integer idStock) {
		boolean maybeUpdate = false;
		Optional<Stock> oStock = stockRepository.findById(idStock);
		if(oStock.isPresent()) {
			Stock stock = oStock.get();
			stock.setServerStatus(1);
			maybeUpdate = true;
		}
		return maybeUpdate;
	}
	public boolean disableStatusStockById(Integer idStock) {
		boolean maybeUpdate = false;
		Optional<Stock> oStock = stockRepository.findById(idStock);
		if(oStock.isPresent()) {
			Stock stock = oStock.get();
			stock.setServerStatus(0);
			maybeUpdate = true;
		}
		return maybeUpdate;
	}
	
	public StatusTransfer<String> sendRequestBuyStockSever(InfoBuyStockDTO stockNeedBuy){
		StatusTransfer<String> status = StatusTransfer.newFailureStatus();
		Optional<Stock> ostock = stockRepository.findById(stockNeedBuy.getIdStock());
		if(ostock.isPresent()){
			Stock stock = ostock.get();
			try {
				// send info stock need buy to correct server
				RestTemplate rest = new RestTemplate();
				String urlNeedSend = stock.getApiBuy();
				HttpEntity<InfoBuyStockDTO> request = new HttpEntity<>(stockNeedBuy);
				rest.postForEntity(urlNeedSend, request, InfoBuyStockDTO.class);
				status.changeStatus(true)
					.setData("Send request buy stock to server of " +  stockNeedBuy.getNameStock() +  " stock success" );
			} catch (Exception e) {
				e.printStackTrace();
				status.setMessage("Failure send action buy stock " + stockNeedBuy.getNameStock());
			}
		}else {
			status.setMessage("This stock is not exist");
		}
		return status;
	}
	public StatusTransfer<String> sendRequestSellStockSever(InfoSellStockDTO stockNeedSell){
		StatusTransfer<String> status = StatusTransfer.newFailureStatus();
		Optional<Stock> ostock = stockRepository.findById(stockNeedSell.getIdStock());
		if(ostock.isPresent()){
			Stock stock = ostock.get();
			try {
				// send info stock need buy to correct server
				RestTemplate rest = new RestTemplate();
				String urlNeedSend = stock.getApiSell();
				HttpEntity<InfoSellStockDTO> request = new HttpEntity<>(stockNeedSell);
				rest.postForEntity(urlNeedSend, request, InfoSellStockDTO.class);
				status.changeStatus(true)
					.setData("Send request sell stock to server of " +  stockNeedSell.getNameStock() +  " stock success" );
			} catch (Exception e) {
				e.printStackTrace();
				status.setMessage("Failure send action sell stock " + stockNeedSell.getNameStock());
			}
		}else {
			status.setMessage("This stock is not exist");
		}
		return status;
	}
}
