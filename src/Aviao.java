
public class Aviao {


	//Status = 1 Avião vai pousar
	//Status = 2 Avião vair decolar
	//Id = numero impar Avião vai pousar
	//Id = numero par Avião vai decolar
	//tempoGastoPD = tempo gasto para pousar e decolar
	
	private int id, satatus, combustivel, tempoGastoAterrisagem, tempoGastoDecolar;
	String empresa;

	public Aviao(int satatus, String empresa) {
		this.satatus = satatus;
		this.empresa = empresa;
		tempoGastoAterrisagem = 0;
		tempoGastoDecolar = 0;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		this.empresa = empresa+" "+id;
	}

	public int getSatatus() {
		return satatus;
	}

	public void setSatatus(int satatus) {
		this.satatus = satatus;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public int getTempoGastoAterrisagem() {
		return tempoGastoAterrisagem;
	}

	public void setTempoGastoAterrisagem(int tempoGastoAterrisagem) {
		this.tempoGastoAterrisagem = tempoGastoAterrisagem;
	}

	public int getTempoGastoDecolar() {
		return tempoGastoDecolar;
	}

	public void setTempoGastoDecolar(int tempoGastoDecolar) {
		this.tempoGastoDecolar = tempoGastoDecolar;
	}
	
	
}
