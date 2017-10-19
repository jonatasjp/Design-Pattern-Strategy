package implementacao;

public class CalculadorPrecoHorasFixaMaisAcrescimoExcedente implements Calculador {

	private int precoPelaHoraExcedente; 
	private int qtdHorasMaxima;
	private int valorFixo;
	
	public CalculadorPrecoHorasFixaMaisAcrescimoExcedente(int precoPelaHoraExcedente, int qtdHorasMaxima, int valorFixo) {
		this.precoPelaHoraExcedente = precoPelaHoraExcedente;
		this.qtdHorasMaxima = qtdHorasMaxima;
		this.valorFixo = valorFixo;
	}

	@Override
	public int calcular(int qtdHoras) {
		int valorTotal = valorFixo;
		if(qtdHoras > qtdHorasMaxima) {
			valorTotal += (qtdHoras - qtdHorasMaxima) * precoPelaHoraExcedente;
		}
		return valorTotal;
	}

}
