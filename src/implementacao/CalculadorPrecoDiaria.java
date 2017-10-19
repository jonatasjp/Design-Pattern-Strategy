package implementacao;

public class CalculadorPrecoDiaria implements Calculador {

	private int valorDiaria;
	
	public CalculadorPrecoDiaria(int valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public int calcular(int qtdHoras) {
		if(qtdHoras > 24) 
			valorDiaria *= (int)(qtdHoras / 24); 
		return valorDiaria;
	}

}
