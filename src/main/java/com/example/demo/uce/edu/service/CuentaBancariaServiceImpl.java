package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CuentaBancariaRepository;
import com.example.demo.uce.edu.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	@Qualifier("Impar")
	private MontoRegaloService montoRegaloService;
	
	
	
	
	@Override
	public void aperturar(CuentaBancaria cuentaBancaria) {
		
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		
		this.cuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria consultar(Integer id) {
		
		return this.cuentaBancariaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.cuentaBancariaRepository.eliminar(id);
	}

	@Override
	public void depositar(Integer id, BigDecimal monto) {
		
		//1. Consulta del saldo a depositar a la apertura de nuestrs cuenta
		CuentaBancaria cuentaBancaria = this.cuentaBancariaRepository.seleccionar(id);
		
		//2. Consutamos al saldo que vamos a aniadir o no
		BigDecimal saldoCuenta = cuentaBancaria.getSaldo();
		
		//3. Tomamos una variable para identificar el dia
		Integer fechaHoy =  LocalDateTime.now().getDayOfMonth();
		
		//4. Iteramos para la recision de la fecha 
		if(fechaHoy % 2 == 0) {
			
			BigDecimal montoAniadir = this.montoRegaloService.calcular(monto);
			
			cuentaBancaria.setSaldo(montoAniadir);
			
			this.cuentaBancariaRepository.actualizar(cuentaBancaria);
		}
		
		else {
			
			cuentaBancaria.setSaldo(saldoCuenta.add(monto));
		
		}
	}

}
