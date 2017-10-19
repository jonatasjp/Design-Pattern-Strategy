package implementacao;

public class TarifaEstacionamento {

	private Calculador calculador;
	
	public TarifaEstacionamento(Calculador calculador) {
		this.calculador = calculador;
	}

	public int calcularTarifa(int qtdHoras) {
		return calculador.calcular(qtdHoras);
	}

}
