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

	public void insereEmergencia(Aviao x) {
		No registroAtual = new No();
		registroAtual.setItem(x);
		
		if(this.vazia()){
			this.primeiro = registroAtual;
			this.tamanho+=1;
		}else {
			registroAtual.setProximo(this.primeiro);
			this.primeiro = registroAtual;
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
	
	public void retiraAviaoSemCombustivel() {
		if(!this.vazia()) {
			No noAtual;
			No proximoNo;
			Aviao proximoAviao;
			noAtual = this.primeiro;
			
			//caso o primeiro da fila esteja com 0 em combustivel
			while(noAtual !=null && noAtual.getItem().getCombustivel()<=0) {
				System.out.println("O aviao "+noAtual.getItem().getEmpresa()+" id: "+noAtual.getItem().getId()+" caiu.");
				this.primeiro = noAtual.getProximo();
				noAtual = this.primeiro;
				this.tamanho--;
			}
			
			while(noAtual!=null) {
				if(noAtual.getProximo() !=null && noAtual.getProximo().getItem().getCombustivel()<=0) {
					if(noAtual.getProximo().getProximo()!=null){
						System.out.println("O aviao "+noAtual.getItem().getEmpresa()+" caiu.");
						proximoNo = noAtual.getProximo().getProximo();
						noAtual.setProximo(proximoNo);
						this.tamanho--;
						noAtual=noAtual.getProximo();
					}else {
						System.out.println("O aviao "+noAtual.getItem().getEmpresa()+" caiu.");
						noAtual.setProximo(null);
						this.tamanho--;
					}
				}else {
					noAtual=noAtual.getProximo();
				}
			}
		}
	}
	
	public Aviao pousoEmergencia() {
		if(!this.vazia()) {
			No noAtual;
			No proximoNo;
			noAtual = this.primeiro;
			Aviao retornoAviao;
			//caso o primeiro da fila esteja com 0 em combustivel
			if(noAtual !=null && noAtual.getItem().getCombustivel()<=3) {
				retornoAviao = this.primeiro.getItem();
				this.primeiro = noAtual.getProximo();
				this.tamanho--;
				return retornoAviao;
			}
			
			while(noAtual!=null) {
				if((noAtual.getProximo() !=null && noAtual.getProximo().getItem()!=null) && noAtual.getProximo().getItem().getCombustivel()<=3) {
					if(noAtual.getProximo().getProximo()!=null) {
						retornoAviao = noAtual.getProximo().getItem();
						proximoNo = noAtual.getProximo().getProximo();
						noAtual.setProximo(proximoNo);
						this.tamanho--;
						return retornoAviao;
					}else {
						retornoAviao = noAtual.getProximo().getItem();
						noAtual.setProximo(null);
						this.tamanho--;
						return retornoAviao;
					}
				}else {
					noAtual = noAtual.getProximo();
				}
			}}
		return null;
	}
	
	private void gerarID(Aviao aviao) {
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
	
	private void gerarTempo(Aviao aviao) {
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
					System.out.println("Aviao "+noAtual.getItem().getEmpresa()+", ID: "+noAtual.getItem().getId()+", Combustivel= "+noAtual.getItem().getCombustivel()+", Tempo na Fila= "+noAtual.getItem().getTempoGastoAterrisagem()+" unidades de tempo.");
				}else if(noAtual.getItem().getSatatus()==2) {
					System.out.println("Aviao "+noAtual.getItem().getEmpresa()+", ID: "+noAtual.getItem().getId()+" esta na FILA para Decolar, Tempo na FILA= "+noAtual.getItem().getTempoGastoDecolar()+" unidades de tempo.");
				}
				noAtual = noAtual.getProximo();
			}
		}
	}
	
	public boolean pesquisaQtdCombustivel() {
		No registroAtual;
		if(this.vazia()) {
			return false;
		}else {
			registroAtual = this.primeiro;
			while(registroAtual!=null) {
				if(registroAtual.getItem().getCombustivel()<=3) {
					return true;
				}
				registroAtual = registroAtual.getProximo();
			}
		}
		return false;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	private void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
