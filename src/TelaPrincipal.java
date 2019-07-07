import java.util.Random;
import java.util.Scanner;

public class TelaPrincipal {
	
	public static int numeroInteracao = 1;
	public static boolean sinalFila1=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	public static boolean sinalFila2=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	public static int contadorDecolagem=0;
	public static int filaPousoP1=0;
	public static int filaPousoP2=0;
	public static int contadorPouso=0;
	public static String empresa1="Varing";
	public static String empresa2="TAM";
	public static String empresa3="GOL";
	public static String empresa4="AZUL";
	public static String empresa5="AVIANCA";
	
	public static void pousarAviaoPista2(FilaEncadeada tres, FilaEncadeada quatro, FilaEncadeada seis) {
		if(filaPousoP2<2) {
			if(!sinalFila2) {
				System.out.println("O aviao "+tres.getPrimeiro().getItem().getEmpresa()+" pousou na Pista 2");
				tres.retiraPrimeiro();
				filaPousoP2+=1;
				sinalFila2 = true;
			}else{
				System.out.println("O aviao "+quatro.getPrimeiro().getItem().getEmpresa()+" pousou na Pista 2");
				quatro.retiraPrimeiro();
				filaPousoP2+=1;
				sinalFila2 = false;
			}
		}else {
			System.out.println("O aviao "+seis.getPrimeiro().getItem().getEmpresa()+" decolou na Pista 2");
			seis.retiraPrimeiro();
			filaPousoP2 = 0;
		}
	}
	
	public static void pousarAviaoPista1(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada cinco) {
		if(filaPousoP1<2) {
			if(!sinalFila1) {
				System.out.println("O aviao "+um.getPrimeiro().getItem().getEmpresa()+" pousou na Pista 1");
				um.retiraPrimeiro();
				filaPousoP1+=1;
				sinalFila1 = true;
			}else{
				System.out.println("O aviao "+dois.getPrimeiro().getItem().getEmpresa()+" pousou na Pista 1");
				dois.retiraPrimeiro();
				filaPousoP1+=1;
				sinalFila1 = false;
			}
		}else {
			System.out.println("O aviao "+cinco.getPrimeiro().getItem().getEmpresa()+" decolou na Pista 1");
			cinco.retiraPrimeiro();
			filaPousoP1 = 0;
		}
	}
	
	public static void listarConteudo(FilaEncadeada um, FilaEncadeada dois,
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
	
	public static void derrubarAviao(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro) {
		
		
	}
	
	public static void decrementarCombustivel(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro) {
		
	}
	
	public static void incrementarTempoGasto(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro,
			   FilaEncadeada cinco, FilaEncadeada seis,
			   FilaEncadeada sete){
		
	}
	
	public static FilaEncadeada verificaMenorFilaDecolar(FilaEncadeada cinco, FilaEncadeada seis, FilaEncadeada sete) {
		int vetor[] = new int[3];
		int aux;
		
		if(cinco.vazia()) {
			return cinco;
		}else if(seis.vazia()) {
			return seis;
		}else if(sete.vazia()) {
			return sete;
		}else {
			vetor[0]=cinco.getTamanho();
			vetor[1]=seis.getTamanho();
			vetor[2]=sete.getTamanho();
			aux=vetor[0];
			for(int i=1;i<vetor.length;i++) {
				if(aux>vetor[i]) {
					aux=vetor[i];
				}
			}
			if(cinco.getTamanho()==aux) {
				return cinco;
			}else if(seis.getTamanho()==aux) {
				return seis;
			}else{
				return sete;
			}
		}
	}

	public static FilaEncadeada verificaMenorFilaPousar(FilaEncadeada um, FilaEncadeada dois, FilaEncadeada tres, FilaEncadeada quatro) {
		int vetor[] = new int[4];
		int aux;
		
		if(um.vazia()) {
			return um;
		}else if(dois.vazia()) {
			return dois;
		}else if(tres.vazia()) {
			return tres;
		}else if(quatro.vazia()) {
			return quatro;
		}else {
			vetor[0]=um.getTamanho();
			vetor[1]=dois.getTamanho();
			vetor[2]=tres.getTamanho();
			vetor[3]=quatro.getTamanho();
			aux=vetor[0];
			for(int i=1;i<vetor.length;i++) {
				if(aux>vetor[i]) {
					aux=vetor[i];
				}
			}
			if(um.getTamanho()==aux) {
				return um;
			}else if(dois.getTamanho()==aux) {
				return dois;
			}else if(tres.getTamanho()==aux) {
				return tres;
			}else{
				return quatro;
			}
		  }
		}
	
	public static void inseriAviao(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro,
			   FilaEncadeada cinco, FilaEncadeada seis,
			   FilaEncadeada sete) {
				Random random = new Random();
				int escolhaEmpresa, qtdAvioes;
				//STATUS == 1 -> POUSAR
				//STATUS == 2 -> DECOLAR
				qtdAvioes = random.nextInt(7);
				int status = 0;
				Aviao aviao;
				System.out.println("Chegou "+qtdAvioes+" avioes.");
				for(int i=0;i<qtdAvioes;i++) {
					if(i%2!=0) {
						status=1;
					}else {
						status=2;
					}
					escolhaEmpresa = random.nextInt(5);
					if(escolhaEmpresa==0) {
						aviao = new Aviao(status,empresa1);
					}else if(escolhaEmpresa==1) {
						aviao = new Aviao(status,empresa2);
					}else if(escolhaEmpresa==2) {
						aviao = new Aviao(status,empresa3);
					}else if(escolhaEmpresa==3) {
						aviao = new Aviao(status,empresa4);
					}else{
						aviao = new Aviao(status,empresa5);
					}
					
					if(status==1 && contadorPouso < 3) {
					verificaMenorFilaPousar(um, dois, tres, quatro).insere(aviao);
					contadorPouso+=1;	
					}else if(status==2 && contadorDecolagem < 3){
					verificaMenorFilaDecolar(cinco, seis, sete).insere(aviao);
					contadorDecolagem+=1;
					}
				}	
				contadorPouso = 0;
				contadorDecolagem = 0;
		}
	
	
	public static void main(String[] args) {
		FilaEncadeada FilaUm = new FilaEncadeada();
		FilaEncadeada FilaDois = new FilaEncadeada();
		FilaEncadeada FilaTres = new FilaEncadeada();
		FilaEncadeada FilaQuatro = new FilaEncadeada();
		FilaEncadeada FilaCinco = new FilaEncadeada();
		FilaEncadeada FilaSeis = new FilaEncadeada();
		FilaEncadeada FilaSete = new FilaEncadeada();
		Scanner scanner = new Scanner(System.in);
		boolean condicao = true;
		String preRequisitoCondicao;
		while(condicao) {
			System.out.println("***************TEMPO "+numeroInteracao+"***********");
			inseriAviao(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			/*incrementarTempoGasto(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			pousarAviaoPista1(FilaUm, FilaDois, FilaCinco);
			pousarAviaoPista2(FilaTres,FilaQuatro,FilaSeis);
			decrementarCombustivel(FilaUm, FilaDois,FilaTres,FilaQuatro);
			derrubarAviao(FilaUm, FilaDois,FilaTres,FilaQuatro);
			listarConteudo(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);*/
			listarConteudo(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			System.out.println();
			System.out.println("Digite S para continuar ou N para parar exucucao");
			preRequisitoCondicao = scanner.nextLine();
			if(preRequisitoCondicao.equalsIgnoreCase("N")) {
				condicao = false;
			}
			numeroInteracao+=1;
		}
	}
}
