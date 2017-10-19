package teste;

import org.junit.Assert;
import org.junit.Test;

import implementacao.CalculadorPrecoDiaria;
import implementacao.CalculadorPrecoHorasFixaMaisAcrescimoExcedente;
import implementacao.CalculadorPrecoPorHoraFixo;
import implementacao.TarifaEstacionamento;

public class TesteTarifaEstacionamentoStrategy {

	@Test
	public void testarValorTarifaComPrecoPorHoraFixo() {
		int precoHora = 5;
		TarifaEstacionamento tarifa = new TarifaEstacionamento(new CalculadorPrecoPorHoraFixo(precoHora));
		
		int qtdHoras = 5;
		int valorTarifa = tarifa.calcularTarifa(qtdHoras);
		
		Assert.assertEquals(25, valorTarifa);
	}
	
	@Test
	public void testarValorTarifaComPrecoPorHorasFixoMaisAcrescimoPorExcedente() {
		int precoPelaHoraExcedente = 10;
		int qtdHorasMaxima = 3;
		int valorFixo = 15;
		TarifaEstacionamento tarifa = new TarifaEstacionamento(new CalculadorPrecoHorasFixaMaisAcrescimoExcedente(precoPelaHoraExcedente, qtdHorasMaxima, valorFixo));
		
		int qtdHoras = 8;
		int valorTarifa = tarifa.calcularTarifa(qtdHoras);
		
		Assert.assertEquals(65, valorTarifa);
	}
	
	@Test
	public void testarValorTarifaComPrecoPorHorasFixoHoraExcedenteMenorQueQuantidadeHorasMaxima() {
		int precoPelaHoraExcedente = 10;
		int qtdHorasMaxima = 3;
		int valorFixo = 15;
		TarifaEstacionamento tarifa = new TarifaEstacionamento(new CalculadorPrecoHorasFixaMaisAcrescimoExcedente(precoPelaHoraExcedente, qtdHorasMaxima, valorFixo));
		
		int qtdHoras = 2;
		int valorTarifa = tarifa.calcularTarifa(qtdHoras);
		
		Assert.assertEquals(15, valorTarifa);
	}
	
	@Test
	public void testarValorTarifaPelaDiaria() {
		int valorDiaria = 30;
		TarifaEstacionamento tarifaEstacionamento = new TarifaEstacionamento(new CalculadorPrecoDiaria(valorDiaria));
		
		int qtdHoras = 50;
		int valorTarifa = tarifaEstacionamento.calcularTarifa(qtdHoras);
		
		Assert.assertEquals(60, valorTarifa);
	}
	
	@Test
	public void testarValorTarifaPelaDiariaMenosDeUmDia() {
		int valorDiaria = 30;
		TarifaEstacionamento tarifaEstacionamento = new TarifaEstacionamento(new CalculadorPrecoDiaria(valorDiaria));
		
		int qtdHoras = 23;
		int valorTarifa = tarifaEstacionamento.calcularTarifa(qtdHoras);
		
		Assert.assertEquals(30, valorTarifa);
	}


}
