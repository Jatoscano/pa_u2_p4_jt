package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import com.example.demo.uce.edu.repository.modelo.CuentaBancaria;

public interface CuentaBancariaService {

	public void aperturar(CuentaBancaria cuentaBancaria);
	public void guardar(CuentaBancaria cuentaBancaria);
    public CuentaBancaria consultar(Integer id);
	public void borrar(Integer id);
	
	public void depositar(Integer id, BigDecimal monto);
}
