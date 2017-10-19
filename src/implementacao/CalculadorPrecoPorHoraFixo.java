package implementacao;

public class CalculadorPrecoPorHoraFixo implements Calculador {

	private int precoHora;
	
	public CalculadorPrecoPorHoraFixo(int precoHora) {
		this.precoHora = precoHora;
	}

	@Override
	public int calcular(int qtdHoras) {
		return qtdHoras * precoHora;
	}

}
