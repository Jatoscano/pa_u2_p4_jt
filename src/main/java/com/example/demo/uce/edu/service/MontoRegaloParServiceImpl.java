package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("Par")
public class MontoRegaloParServiceImpl implements MontoRegaloService{

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		
		BigDecimal porcentaje = monto.multiply(new BigDecimal(0.05));
		
		return monto.add(porcentaje);
	}

}
