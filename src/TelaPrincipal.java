import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class TelaPrincipal {
	
	public static int numeroInteracao = 1;
	
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
			controle.listarConteudo(FilaUm, FilaDois,FilaTres,FilaQuatro,FilaCinco,FilaSeis,FilaSete);
			System.out.println();
			System.out.println("-------------------------------------");
			if(controle.getQtdPouso()!=0) {
				double mediaPouso = (double)controle.getSomaTotalTempoGastoPouso()/(double)controle.getQtdPouso();
				System.out.println("Quantidade de pouso(s) realizados -> "+controle.getQtdPouso());
				System.out.println("Tempo medio para pousar --> "+mediaPouso+" unidades de tempo.");
			}else {
				System.out.println("Quantidade de pouso(s) realizados -> "+controle.getQtdPouso());
			}
			System.out.println("-------------------------------------");
			if(controle.getQtdDecolagem()!=0) {
				System.out.println(controle.getSomaTotalTempoGastoDecolgem());
				double mediaDecolagem = (double)controle.getSomaTotalTempoGastoDecolgem()/(double)controle.getQtdDecolagem();
				System.out.println("Quantidade de decolagens realizadas -> "+controle.getQtdDecolagem());
				System.out.println("Tempo medio para decolar --> "+mediaDecolagem+" unidades de tempo.");
			}else {
				System.out.println("Quantidade de decolagens realizados -> "+controle.getQtdDecolagem());
			}
			System.out.println("-------------------------------------");
			System.out.println("Digite S para continuar ou N para parar exucucao");
			preRequisitoCondicao = scanner.nextLine();
			if(preRequisitoCondicao.equalsIgnoreCase("N")) {
				condicao = false;
			}
			numeroInteracao+=1;
		}
	}
}
