package com.sang.sangsever.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.sangsever.dto.InfoBuyStockDTO;
import com.sang.sangsever.dto.InfoSellStockDTO;
import com.sang.sangsever.dto.StatusTransfer;
import com.sang.sangsever.repo.StockService;

@Controller
@RequestMapping(path = "api/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@PostMapping("/buy-stock")
	public ResponseEntity<String> requestBuyStock(@RequestBody InfoBuyStockDTO stockNeedBuy) {
		try {
			StatusTransfer<String> status = stockService.sendRequestBuyStockSever(stockNeedBuy);
			if(status.isStatus() == true) {
				return ResponseEntity.ok().body(status.getMessage());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Fail transaction. please contact to admin");
		}
	}
	@PostMapping("/sell-stock")
	public ResponseEntity<String> requestBuyStock(@RequestBody InfoSellStockDTO stockNeedSell) {
		try {
			StatusTransfer<String> status = stockService.sendRequestSellStockSever(stockNeedSell);
			if(status.isStatus() == true) {
				return ResponseEntity.ok().body(status.getMessage());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Fail transaction. please contact to admin");
		}
	}

	
}
