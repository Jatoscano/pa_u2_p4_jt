package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("Impar")
public class MontoRegaloImparServiceImpl implements MontoRegaloService{

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		
		return monto;
	}

}
