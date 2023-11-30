package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("\nDigite os dados do %d° contribuinte:\n", i);
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthIncome = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthIncome, educationSpending));
        }
        sc.close();

        for (TaxPayer taxPayer : taxPayers) {
            System.out.printf("\nResumo do %do contribuinte:\n", taxPayers.indexOf(taxPayer) + 1);
            System.out.println(taxPayer);
        }
    }
}
