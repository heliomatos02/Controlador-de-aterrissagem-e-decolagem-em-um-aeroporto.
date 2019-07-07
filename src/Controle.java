import java.util.Random;

public class Controle {

	private static final String empresa1 = "Varing";
	private static final String empresa2 = "TAM";
	private static final String empresa3 = "GOL";
	private static final String empresa4 = "AZUL";
	private static final String empresa5 = "AVIANCA";
	private int contadorPouso = 0;
	private int contadorDecolagem = 0;

	public void inseriAviao(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada tres, FilaEncadeada quatro,
			FilaEncadeada cinco, FilaEncadeada seis, FilaEncadeada sete) {
		Random random = new Random();
		int escolhaEmpresa, qtdAvioes;
		// STATUS == 1 -> POUSAR
		// STATUS == 2 -> DECOLAR
		qtdAvioes = random.nextInt(7);
		int status = 0;
		Aviao aviao;
		
		/*decremetar combustivel dos avioes que irao pousar*/
		decrementarCombustivel(um, dois, tres, quatro);
		/*fim decremetar combustivel dos avioes que irao pousar*/
		/*incrementa o tempo nos avioes nas filas Pousar*/
		incrementarTempoGastoPousar(um, dois, tres, quatro);
		/*fim incrementa o tempo nos avioes nas filas*/
		
		/*incrementa o tempo nos avioes nas filas Decolar*/
		incrementarTempoGastoDecolar(cinco, seis, sete);
		/*fim incrementa o tempo nos avioes nas filas Decolar*/
		System.out.println("Chegou " + qtdAvioes + " avioes.");
		for (int i = 0; i < qtdAvioes; i++) {
			if (i % 2 != 0) {
				status = 1;
			} else {
				status = 2;
			}
			escolhaEmpresa = random.nextInt(5);
			if (escolhaEmpresa == 0) {
				aviao = new Aviao(status, empresa1);
			} else if (escolhaEmpresa == 1) {
				aviao = new Aviao(status, empresa2);
			} else if (escolhaEmpresa == 2) {
				aviao = new Aviao(status, empresa3);
			} else if (escolhaEmpresa == 3) {
				aviao = new Aviao(status, empresa4);
			} else {
				aviao = new Aviao(status, empresa5);
			}

			if (status == 1 && contadorPouso < 3) {
				verificaMenorFilaPousar(um, dois, tres, quatro).insere(aviao);
				contadorPouso += 1;
			} else if (status == 2 && contadorDecolagem < 3) {
				verificaMenorFilaDecolar(cinco, seis, sete).insere(aviao);
				contadorDecolagem += 1;
			}
		}
		contadorPouso = 0;
		contadorDecolagem = 0;
	}

	public FilaEncadeada verificaMenorFilaDecolar(FilaEncadeada cinco, FilaEncadeada seis, FilaEncadeada sete) {
		int vetor[] = new int[3];
		int aux;

		if (cinco.vazia()) {
			return cinco;
		} else if (seis.vazia()) {
			return seis;
		} else if (sete.vazia()) {
			return sete;
		} else {
			vetor[0] = cinco.getTamanho();
			vetor[1] = seis.getTamanho();
			vetor[2] = sete.getTamanho();
			aux = vetor[0];
			for (int i = 1; i < vetor.length; i++) {
				if (aux > vetor[i]) {
					aux = vetor[i];
				}
			}
			if (cinco.getTamanho() == aux) {
				return cinco;
			} else if (seis.getTamanho() == aux) {
				return seis;
			} else {
				return sete;
			}
		}
	}

	public FilaEncadeada verificaMenorFilaPousar(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada tres,
			FilaEncadeada quatro) {
		int vetor[] = new int[4];
		int aux;

		if (um.vazia()) {
			return um;
		} else if (dois.vazia()) {
			return dois;
		} else if (tres.vazia()) {
			return tres;
		} else if (quatro.vazia()) {
			return quatro;
		} else {
			vetor[0] = um.getTamanho();
			vetor[1] = dois.getTamanho();
			vetor[2] = tres.getTamanho();
			vetor[3] = quatro.getTamanho();
			aux = vetor[0];
			for (int i = 1; i < vetor.length; i++) {
				if (aux > vetor[i]) {
					aux = vetor[i];
				}
			}
			if (um.getTamanho() == aux) {
				return um;
			} else if (dois.getTamanho() == aux) {
				return dois;
			} else if (tres.getTamanho() == aux) {
				return tres;
			} else {
				return quatro;
			}
		}
	}
	
	public void listarConteudo(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro,
			   FilaEncadeada cinco, FilaEncadeada seis,
			   FilaEncadeada sete) {
		
		System.out.println("---------Conteudo Prateleira 1 - PISTA 1 - "+" "+um.getTamanho()+" avioes ---------");
		um.imprimirConteudo();
		System.out.println("\n---------Conteudo Prateleira 2 - PISTA 1 - "+" "+dois.getTamanho()+" avioes ---------");
		dois.imprimirConteudo();
		System.out.println("\n---------Conteudo Prateleira 3 - PISTA 2 - "+" "+tres.getTamanho()+" avioes ---------");
		tres.imprimirConteudo();
		System.out.println("\n---------Conteudo Prateleira 4 - PISTA 2 - "+" "+quatro.getTamanho()+" avioes ---------");
		quatro.imprimirConteudo();
		System.out.println("\n---------Conteudo FILA 5 - PISTA 1 - "+" "+cinco.getTamanho()+" avioes ---------");
		cinco.imprimirConteudo();
		System.out.println("\n---------Conteudo FILA 6 - PISTA 2 - "+" "+seis.getTamanho()+" avioes ---------");
		seis.imprimirConteudo();
		System.out.println("\n---------Conteudo FILA 7 - PISTA 3 - "+" "+sete.getTamanho()+" avioes ---------");
		sete.imprimirConteudo();
		
	}
	
	private void incrementarTempoGastoPousar(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro){
		
		No aviaoAserIncrementado = um.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoAterrisagem(aviaoAserIncrementado.getItem().getTempoGastoAterrisagem()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
		
		aviaoAserIncrementado = dois.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoAterrisagem(aviaoAserIncrementado.getItem().getTempoGastoAterrisagem()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
		
		aviaoAserIncrementado = tres.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoAterrisagem(aviaoAserIncrementado.getItem().getTempoGastoAterrisagem()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
		
		aviaoAserIncrementado = quatro.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoAterrisagem(aviaoAserIncrementado.getItem().getTempoGastoAterrisagem()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
	}
	
	private void incrementarTempoGastoDecolar(FilaEncadeada cinco, FilaEncadeada seis,
			   FilaEncadeada sete){
		
		No aviaoAserIncrementado = cinco.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoDecolar(aviaoAserIncrementado.getItem().getTempoGastoDecolar()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
		
		aviaoAserIncrementado = seis.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoDecolar(aviaoAserIncrementado.getItem().getTempoGastoDecolar()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
		
		aviaoAserIncrementado = sete.getPrimeiro();
		while(aviaoAserIncrementado!=null) {
			aviaoAserIncrementado.getItem().setTempoGastoDecolar(aviaoAserIncrementado.getItem().getTempoGastoDecolar()+1);
			aviaoAserIncrementado = aviaoAserIncrementado.getProximo();
		}
	}
	
	private static void decrementarCombustivel(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro) {
		
		No aviaoAserDecrementado = um.getPrimeiro();
		while(aviaoAserDecrementado!=null) {
			aviaoAserDecrementado.getItem().setCombustivel(aviaoAserDecrementado.getItem().getCombustivel()-1);
			aviaoAserDecrementado = aviaoAserDecrementado.getProximo();
		}
		
		aviaoAserDecrementado = dois.getPrimeiro();
		while(aviaoAserDecrementado!=null) {
			aviaoAserDecrementado.getItem().setCombustivel(aviaoAserDecrementado.getItem().getCombustivel()-1);
			aviaoAserDecrementado = aviaoAserDecrementado.getProximo();
		}
		
		aviaoAserDecrementado = tres.getPrimeiro();
		while(aviaoAserDecrementado!=null) {
			aviaoAserDecrementado.getItem().setCombustivel(aviaoAserDecrementado.getItem().getCombustivel()-1);
			aviaoAserDecrementado = aviaoAserDecrementado.getProximo();
		}
		
		aviaoAserDecrementado = quatro.getPrimeiro();
		while(aviaoAserDecrementado!=null) {
			aviaoAserDecrementado.getItem().setCombustivel(aviaoAserDecrementado.getItem().getCombustivel()-1);
			aviaoAserDecrementado = aviaoAserDecrementado.getProximo();
		}
	}
}
