import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> lista = new ArrayList<>();

        System.out.println("Enter the number of tax payers:");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Name:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();
            if(tipo == 'c'){
                System.out.print("Number of employees: ");
                int qtd = sc.nextInt();
                lista.add(new Company(name, income, qtd));
                sc.nextLine();
            }
            if(tipo == 'i'){
                System.out.print("Health expenditures: ");
                double saude = sc.nextDouble();
                lista.add(new Individual(name, income, saude));
                sc.nextLine();
            }
        }

        System.out.println();
        double sum = 0;
        System.out.println("TAXES PAID:");
        for(TaxPayer tp : lista){
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        sc.close();
    }
}