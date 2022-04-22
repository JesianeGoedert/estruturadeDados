package trabalho1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Fila filaChegada = new Fila();
		
		filaChegada.inserir(1);
		filaChegada.inserir(2);
		filaChegada.inserir(3);
		filaChegada.inserir(4);
		
		Pilha pilhaPratos = new Pilha();
		
		pilhaPratos.push(1);
		pilhaPratos.push(2);
		pilhaPratos.push(3);
		pilhaPratos.push(4);
		pilhaPratos.push(5);
		pilhaPratos.push(6);
		pilhaPratos.push(7);
		pilhaPratos.push(8);
		pilhaPratos.push(9);
		pilhaPratos.push(10);
		pilhaPratos.push(11);
		pilhaPratos.push(12);
		
	
		//Lista pr�-definida de 15 mesas
		ListaEncadeada listE = new ListaEncadeada(1, "Dispon�vel", 0);
		
		listE.inseririnicio(2, "Dispon�vel", 0);
		listE.inseririnicio(3, "Dispon�vel", 0);
		listE.inseririnicio(4, "Dispon�vel", 0);
		listE.inseririnicio(5, "Indispon�vel", 0);
		listE.inseririnicio(6, "Indispon�vel", 0);
		listE.inseririnicio(7, "Dispon�vel", 0);
		listE.inseririnicio(8, "Dispon�vel", 0);
		listE.inseririnicio(9, "Dispon�vel", 0);
		listE.inseririnicio(10, "Dispon�vel", 0);
		listE.inseririnicio(11, "Dispon�vel", 0);
		listE.inseririnicio(12, "Dispon�vel", 0);
		listE.inseririnicio(13, "Dispon�vel", 0);
		listE.inseririnicio(14, "Dispon�vel", 0);
		listE.inseririnicio(15, "Indispon�vel", 0);
		
		Fila filaCaixa = new Fila();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n    SEJA BEM-VINDO AO RESTAURANTE TELHADINHO! \n"
				+ "    ------------------------------------------ \n");
		
		int codPessoasChegada = 0;
		int codPratos = 0;
		int codPessoasCaixa = 0;
		NodoListaEncadeada aux;
		int numFilaAlmocar =  filaChegada.getTamanho();
		int numFilaCaixa = filaCaixa.getTamanho();
		int numAtendidos = 0;
		
		while(true) {
			
			int numFilaChegada = 0;
			
			while(true) {
				
				System.out.println("\n Menu:\n");
				System.out.println(" 1- Entrada no restaurante\n"
						+ " 2 - Relat�rio geral do restaurante\n"
						+ " 3 - Sair" );
				
				int menu = input.nextInt();
				
			
				if(menu == 1) {
				
					System.out.println(" Entrar na fila de chegada? 1- Sim | 2 - N�o");
					int a = input.nextInt();
					
					if(a == 2) {
						System.out.println(" Esperamos por voc� na pr�xima vez!\n");
					}
					if(a == 1) {
						codPessoasChegada++;
						
							System.out.println(" N� de pessoas na fila: " + filaChegada.filaDeChegada(filaChegada, codPessoasChegada));
							
							if(filaChegada.getTamanho() < filaChegada.getLimite()) {
							
								System.out.println(" \nLISTA DE MESAS DISPON�VEIS:\n");
								System.out.println(listE.mostrarListaMesas());
								
								System.out.println(" H� " + listE.numMesasDispon�veis() + " mesas dispon�veis\n");
								
								int x;
								
								while(true) {
									
									System.out.println(" Escolha uma mesa:\n");
									x = input.nextInt();
									
									if(listE.mesaEstaDisponivel(x) == 1) {
										break;
									}
									else {
										System.out.println(" Mesa indispon�vel! Escolha outra mesa:\n");
									}
									
								}
							
								listE.setCodMesa(x);
								
								filaChegada.remover();
								numFilaAlmocar =  filaChegada.getTamanho();
								
								System.out.println(" N� de pessoas na fila de entrada: " + filaChegada.getTamanho());
								
								System.out.println(" Descreva sua refei��o:");
								String descricaoRefeicao = input.next();
								
								input.nextLine();
								
								System.out.println(" Digite o valor dos gastos da mesa:");
								listE.setGastos(input.nextDouble());
								
								if(pilhaPratos.getTamanho() == 0) {
									System.out.println(" N�o h� pratos, infelizmente n�o podemos atend�-lo. \n");
									System.exit(0);
								}
								pilhaPratos.pop(); //remove da lista de pratos
								
								
								System.out.println(" \n AGORA EFETUAR PAGAMENTO...\n");
								codPessoasCaixa++; //Auto incremento de c�digo 
								numAtendidos++; //contador de pessoas atendidas
								
								System.out.println(" N� de pessoas na fila do caixa: " + filaCaixa.filaDoCaixa(filaCaixa, codPessoasCaixa));
								
								
								System.out.println();
								System.out.println(" Mesa: " + listE.getCodMesa());
								System.out.println(" Refei��o: " + descricaoRefeicao);
								System.out.println(" Gastos: R$ " + listE.getGastos() + " \n ");
								
								listE.setSituacao("Dispon�vel");
								listE.setGastos(0);
								pilhaPratos.push(codPratos);
								filaCaixa.remover();
								numFilaCaixa = filaCaixa.getTamanho();

								System.out.println(" H� " + pilhaPratos.getTamanho() + " pratos na pilha\n");
								System.out.println(" H� " + listE.numMesasDispon�veis() + " mesas dispon�veis\n");
			
								
							}
							else {
								System.out.println(" Aguarde...");;
							}
							
				}//if a == 1
				
				}//IF menu
				
				if(menu == 2) {{ 
					
					System.out.println(" -----------  RELAT�RIO  ----------\n");
					
					System.out.println(" N�mero de pessoas na fila para almo�ar: " +numFilaAlmocar);
					
					System.out.println(" Numero de pessoas na fila do caixa: " + numFilaCaixa);
					
					int numAlmocando = 15-listE.numMesasDispon�veis();
					System.out.println(" N� de pessoas almo�ando no restaurante: " + numAlmocando);
	
					System.out.println(" N� de pessoas atendidas no restaurante: " + numAtendidos);
					
					System.out.println(" N� de pratos na pilha: " + pilhaPratos.getTamanho());

					int mesasDisponiveis = listE.numMesasDispon�veis();
					System.out.println(" N� de mesas dispon�veis: " + mesasDisponiveis + "\n");
				}
				
				
			}
			
			if(menu == 3) {
				System.out.println(" ----------------");
				System.out.println(" Fim do programa.");
				System.out.println(" ----------------");
		        System.exit(0);
			}
	
		
		}//while 2	
			 
	}//while 1
	}
}
