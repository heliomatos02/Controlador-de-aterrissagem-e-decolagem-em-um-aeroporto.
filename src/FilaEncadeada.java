import java.util.Random;

public class FilaEncadeada{
	private static int idDecolar=0;
	private static int idPousar=1;
	private No primeiro = new No();
	private int tamanho=0;
	
	
	public No getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}

	public FilaEncadeada() {
		this.primeiro = null;
		this.tamanho = 0;
	}
	
	public void insere(Aviao x) {
		No registroAtual = new No();
		gerarID(x);
		if(x.getSatatus()==1) {//pousar
			gerarTempo(x);
		}
		registroAtual.setItem(x);
		if(this.vazia()) {
			this.primeiro = registroAtual;
			this.tamanho+=1;
		}else {
			No aux = this.primeiro;
			while(aux.getProximo()!=null) {
				aux=aux.getProximo();
			}
			aux.setProximo(registroAtual);
			this.tamanho+=1;
		}
	}

	public boolean vazia() {
		return this.primeiro == null ? true : false;	
	}
	
	public Aviao retiraPrimeiro() {
		Aviao aviao;
		if(this.vazia()) {
			return null;
		}else {
			No aux = this.primeiro;
			aviao = aux.getItem();
			this.primeiro = aux.getProximo();
			this.tamanho--;
			return aviao;
		}
	}
	
	public void gerarID(Aviao aviao) {
		int id = 0;
		Random random = new Random();
		
		if(aviao.getSatatus()==1) {//Avião vai pousar
			aviao.setId(idPousar);
			idPousar+=2;
		}else {//Avião vai decolar
			aviao.setId(idDecolar);
			idDecolar+=2;
		}
	}
	
	public void gerarTempo(Aviao aviao) {
		int tempo = 0;
		Random random = new Random();
		
		while(tempo<1 || tempo>20) {
			tempo = random.nextInt(21);
		}
		
		aviao.setCombustivel(tempo);
	}
	
	
	public void imprimirConteudo() {
		if(!this.vazia()) {
			No noAtual;
			noAtual = this.primeiro;
			while(noAtual !=null) {
				if(noAtual.getItem().getSatatus()==1) {
					System.out.println("Aviao "+noAtual.getItem().getEmpresa()+", Combustivel= "+noAtual.getItem().getCombustivel()+", Tempo na Fila= "+noAtual.getItem().getTempoGastoAterrisagem()+" unidades de tempo.");
				}else if(noAtual.getItem().getSatatus()==2) {
					System.out.println("Aviao "+noAtual.getItem().getEmpresa()+" esta na FILA para Decolar, Tempo na FILA= "+noAtual.getItem().getTempoGastoDecolar()+" unidades de tempo.");
				}
				noAtual = noAtual.getProximo();
			}
		}
	}
	
	
	public int getTamanho() {
		return tamanho;
	}

	private void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
}
