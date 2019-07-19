import java.util.Random;

public class Controle {

	private boolean sinalFila1=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	private boolean sinalFila2=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	private static final String empresa1 = "Varing";
	private static final String empresa2 = "TAM";
	private static final String empresa3 = "GOL";
	private static final String empresa4 = "AZUL";
	private static final String empresa5 = "AVIANCA";
	private Aviao retiraPrimeroAviao;
	private Aviao retiraAviaoEmergencia;
	private int contadorPouso = 0;
	private int contadorDecolagem = 0;
	private int filaPousoP1=0;
	private int filaPousoP2=0;
	private int retornoPousoEdecolagemP1=0;
	private int retornoPousoEdecolagemP2=0;
	private int retornoPousoEdecolagemP3=0;
	
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

	private FilaEncadeada verificaMenorFilaDecolar(FilaEncadeada cinco, FilaEncadeada seis, FilaEncadeada sete) {
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

	private FilaEncadeada verificaMenorFilaPousar(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada tres,
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
		um.retiraAviaoSemCombustivel();
		retornoPousoEdecolagemP1 = pousarAviaoPista1(um, dois, cinco);
		if(retornoPousoEdecolagemP1==1 && (um!=null && um.getPrimeiro()!=null)) {
			retiraPrimeroAviao = um.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" pousou na Pista 1");
			zeraRetornoPousoEdecolagemP1();
		}
		System.out.println(um.pesquisaQtdCombustivel());
		
		System.out.println("\n---------Conteudo Prateleira 2 - PISTA 1 - "+" "+dois.getTamanho()+" avioes ---------");
		dois.imprimirConteudo();
		dois.retiraAviaoSemCombustivel();
		if(retornoPousoEdecolagemP1==2 && (dois!=null && dois.getPrimeiro()!=null)) {
			retiraPrimeroAviao = dois.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" pousou na Pista 1");
			zeraRetornoPousoEdecolagemP1();
		}
		System.out.println(dois.pesquisaQtdCombustivel());
		
		System.out.println("\n---------Conteudo Prateleira 3 - PISTA 2 - "+" "+tres.getTamanho()+" avioes ---------");
		tres.imprimirConteudo();
		tres.retiraAviaoSemCombustivel();
		retornoPousoEdecolagemP2 = pousarEdecolarAviaoPista2(tres, quatro, seis);
		if(retornoPousoEdecolagemP2==3 && (tres!=null && tres.getPrimeiro()!=null)) {
			retiraPrimeroAviao = tres.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" pousou na Pista 2");
			zeraRetornoPousoEdecolagemP2();
		}
		System.out.println(tres.pesquisaQtdCombustivel());
		
		System.out.println("\n---------Conteudo Prateleira 4 - PISTA 2 - "+" "+quatro.getTamanho()+" avioes ---------");
		quatro.imprimirConteudo();
		quatro.retiraAviaoSemCombustivel();
		if(retornoPousoEdecolagemP2==4 && (quatro!=null && quatro.getPrimeiro()!=null)) {
			retiraPrimeroAviao = quatro.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" pousou na Pista 2");
			zeraRetornoPousoEdecolagemP2();
		}
		System.out.println(quatro.pesquisaQtdCombustivel());
		
		System.out.println("\n---------Conteudo FILA 5 - PISTA 1 - "+" "+cinco.getTamanho()+" avioes ---------");
		cinco.imprimirConteudo();
		if(retornoPousoEdecolagemP1==5) {
			retiraPrimeroAviao = cinco.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" decolou na Pista 1");
			zeraRetornoPousoEdecolagemP1();
		}
		
		System.out.println("\n---------Conteudo FILA 6 - PISTA 2 - "+" "+seis.getTamanho()+" avioes ---------");
		seis.imprimirConteudo();
		if(retornoPousoEdecolagemP2==6) {
			retiraPrimeroAviao = seis.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" decolou na Pista 2");
			zeraRetornoPousoEdecolagemP2();
		}
		
		System.out.println("\n---------Conteudo FILA 7 - PISTA 3 - "+" "+sete.getTamanho()+" avioes ---------");
		sete.imprimirConteudo();
		retornoPousoEdecolagemP3 = pousarEdecolarAviaoPista3(um, dois, tres, quatro, sete);
		if(retornoPousoEdecolagemP3==7) {
			retiraPrimeroAviao = sete.retiraPrimeiro();
			System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" decolou na Pista 2");
			zeraRetornoPousoEdecolagemP3();
		}else if(retornoPousoEdecolagemP3==1) {
			retiraAviaoEmergencia = um.pousoEmergencia();
			inserirAviaoPousoEmergencia(sete, retiraAviaoEmergencia);
			//System.out.println("O aviao "+retiraAviaoEmergencia.getEmpresa()+" id: "+retiraAviaoEmergencia.getId()+" pousou na Pista 3");
			//zeraRetornoPousoEdecolagemP3();
		}else if(retornoPousoEdecolagemP3==2) {
			retiraAviaoEmergencia = dois.pousoEmergencia();
			inserirAviaoPousoEmergencia(sete, retiraAviaoEmergencia);
			/*System.out.println("O aviao "+retiraAviaoEmergencia.getEmpresa()+" id: "+retiraAviaoEmergencia.getId()+" pousou na Pista 3");
			zeraRetornoPousoEdecolagemP3();*/
		}else if(retornoPousoEdecolagemP3==3) {
			retiraAviaoEmergencia = tres.pousoEmergencia();
			inserirAviaoPousoEmergencia(sete, retiraAviaoEmergencia);
			/*System.out.println("O aviao "+retiraAviaoEmergencia.getEmpresa()+" id: "+retiraAviaoEmergencia.getId()+" pousou na Pista 3");
			zeraRetornoPousoEdecolagemP3();*/
		}else if(retornoPousoEdecolagemP3==4) {
			retiraAviaoEmergencia = quatro.pousoEmergencia();
			inserirAviaoPousoEmergencia(sete, retiraAviaoEmergencia);
			/*System.out.println("O aviao "+retiraAviaoEmergencia.getEmpresa()+" id: "+retiraAviaoEmergencia.getId()+" pousou na Pista 3");
			zeraRetornoPousoEdecolagemP3();*/
		}
		
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
	
	private int pousarAviaoPista1(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada cinco) {
		if((um.getPrimeiro()!=null || dois.getPrimeiro()!=null) && (filaPousoP1==0 || cinco.getPrimeiro()==null || verificaPrateleiraFila(dois) || verificaPrateleiraFila(um))){
			if((verificaPrateleiraFila(um))) {
				filaPousoP1+=1;
				sinalFila1 = true;
				return 1;
			}else if(verificaPrateleiraFila(dois)){
				filaPousoP1+=1;
				sinalFila1 = false;
				return 2;
			}else if(!sinalFila1) {
				filaPousoP1+=1;
				sinalFila1 = true;
				return 1;
			}else {
				filaPousoP1+=1;
				sinalFila1 = false;
				return 2;
			}
		}else if(cinco!=null && cinco.getPrimeiro()!=null){
			filaPousoP1 = 0;
			return 5;
		}
		return -1;
	}
	
	
	private boolean verificaPrateleiraFila(FilaEncadeada filaEncadeada) {
		if(((filaEncadeada != null && filaEncadeada.getPrimeiro()!=null) && (filaEncadeada.getPrimeiro().getItem().getCombustivel()<=3))) {
			return true;
		}
		return false;
	}
	
	private int pousarEdecolarAviaoPista2(FilaEncadeada tres, FilaEncadeada quatro, FilaEncadeada seis) {
		if( (tres.getPrimeiro()!=null || quatro.getPrimeiro()!=null) && (filaPousoP2==0 || seis.getPrimeiro()==null || verificaPrateleiraFila(quatro) || verificaPrateleiraFila(tres))){
			if((verificaPrateleiraFila(tres))) {
				filaPousoP2+=1;
				sinalFila2 = true;
				return 3;
			}else if(verificaPrateleiraFila(quatro)){
				filaPousoP2+=1;
				sinalFila2 = false;
				return 4;
			}else if(!sinalFila2) {
				filaPousoP2+=1;
				sinalFila2 = true;
				return 3;
			}else {
				filaPousoP2+=1;
				sinalFila2 = false;
				return 4;
			}
		}else if(seis!=null && seis.getPrimeiro()!=null){
			filaPousoP2 = 0;
			return 6;
		}
		return -1;
	}
	
	private int pousarEdecolarAviaoPista3(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada tres, FilaEncadeada quatro, FilaEncadeada sete) {
		
		if(um.pesquisaQtdCombustivel()) {
			return 1;
		}else if(dois.pesquisaQtdCombustivel()) {
			return 2;
		}else if(tres.pesquisaQtdCombustivel()) {
			return 3;
		}else if(quatro.pesquisaQtdCombustivel()) {
			return 4;
		}else if(sete!=null && sete.getPrimeiro()!=null) {
			return 7;
		}
		return -1;
	}
	
	private void inserirAviaoPousoEmergencia(FilaEncadeada filaEncadeada, Aviao aviao) {
		filaEncadeada.insereEmergencia(aviao);
		System.out.println("O aviao "+aviao.getEmpresa()+" id: "+aviao.getId()+" foi inserido na Fila 7 para realizar um pouso de emergencia.");
		retiraPrimeroAviao = filaEncadeada.retiraPrimeiro();
		System.out.println("O aviao "+retiraPrimeroAviao.getEmpresa()+" id: "+retiraPrimeroAviao.getId()+" conseguiu pousar na Pista 3");
	}
	
	private void zeraRetornoPousoEdecolagemP1() {
		retornoPousoEdecolagemP1 = 0;
	}
	
	private void zeraRetornoPousoEdecolagemP2() {
		retornoPousoEdecolagemP2 = 0;
	}
	
	private void zeraRetornoPousoEdecolagemP3() {
		retornoPousoEdecolagemP3 = 0;
	}
}
