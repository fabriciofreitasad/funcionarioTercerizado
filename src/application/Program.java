package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitie.Funcionario;
import entitie.FuncionarioTerceirizado;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		
		System.out.print("Qual é a quantidade de funcionarios? ");
		int n = sc.nextInt();
		
		for(int i =1; i<=n; i++) {
			System.out.println("Funcionario #"+i);
			System.out.print("O funcionario é tercerizado: y/n? ");
			char ch = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Quantidade de horas: ");
			int horas = sc.nextInt();
			System.out.println("Valor da hora?: ");
			double valorHora = sc.nextDouble();
			if(ch == 'y') {
				System.out.println("Digite o valor da taxa: ");
				double cobrancaAdicional = sc.nextDouble();
				list.add(new FuncionarioTerceirizado(nome, horas, valorHora, cobrancaAdicional));
			}
			else {
				list.add(new Funcionario(nome, horas, valorHora));
			}
		}
		
		System.out.println();
		System.out.println("Pagamentos:");
		for( Funcionario fun : list) {
			System.out.println(fun.getNome()+" - $ "+ String.format("%.2f", fun.pagamento()));
		}
		
		
		
		
		sc.close();

	}

}
