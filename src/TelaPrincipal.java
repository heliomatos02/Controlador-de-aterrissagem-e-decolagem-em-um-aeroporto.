import java.util.Random;
import java.util.Scanner;

public class TelaPrincipal {
	
	public static int numeroInteracao = 1;
	public static boolean sinalFila1=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	public static boolean sinalFila2=false;//FALSE = POUSA PRATILEIRA 1 // TRUE = POUSA PRATELEIRA 2 (AMBOS DA FILA 1)
	public static int filaPousoP1=0;
	public static int filaPousoP2=0;
	
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
	
	public static void derrubarAviao(FilaEncadeada um, FilaEncadeada dois,
			   FilaEncadeada tres, FilaEncadeada quatro) {
		
		
	}
	
	public static void main(String[] args) {
		FilaEncadeada FilaUm = new FilaEncadeada();
		FilaEncadeada FilaDois = new FilaEncadeada();
		FilaEncadeada FilaTres = new FilaEncadeada();
		FilaEncadeada FilaQuatro = new FilaEncadeada();
		FilaEncadeada FilaCinco = new FilaEncadeada();
		FilaEncadeada FilaSeis = new FilaEncadeada();
		FilaEncadeada FilaSete = new FilaEncadeada();
		Controle controle = new Controle();
		Scanner scanner = new Scanner(System.in);
		boolean condicao = true;
		String preRequisitoCondicao;
		while(condicao) {
			System.out.println("***************TEMPO "+numeroInteracao+"***********");
			controle.inseriAviao(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			/*incrementarTempoGasto(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			pousarAviaoPista1(FilaUm, FilaDois, FilaCinco);
			pousarAviaoPista2(FilaTres,FilaQuatro,FilaSeis);
			decrementarCombustivel(FilaUm, FilaDois,FilaTres,FilaQuatro);
			derrubarAviao(FilaUm, FilaDois,FilaTres,FilaQuatro);
			listarConteudo(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);*/
			controle.listarConteudo(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
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
