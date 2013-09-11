import java.util.Scanner;

public class Main{

	//folosim verifica pt a verifica daca functia e definita
	public static boolean verifica(String th) {
		boolean a;
		a=false;
		
		if (th.equals("add_one"))
			a = true;
		if (th.equals("multiply_by_five"))
			a = true;
		if (th.equals("subtract_three"))
			a = true;
		if (th.equals("add_two"))
			a = true;
		if (th.equals("multiply_by_three"))
			a = true;
		return a;
	}

	
	public static int functie(String th, int n) {
		if (th.equals("add_one"))
			n = n + 1;
		if (th.equals("multiply_by_five"))
			n = n * 5;
		if (th.equals("subtract_three"))
			n = n - 3;
		if (th.equals("add_two"))
			n = n + 2;
		if (th.equals("multiply_by_three"))
			n = n * 3;
		return n;
	}

	public static void main(String[] args) {

		String var, aux, aux3; 
		int a, n;
		System.out.println("Functiile definite sunt: add_one, multiply_by_five, subtract_three, add_two si multiply_by_three");
		
		Scanner input = new Scanner(System.in);
	
			
			
		
		System.out.println("Introduceti numarul intreg:");
		//Citim numarul intreg de la tastatura
		n=input.nextInt();
		input.nextLine();
		//Citim colectia de functii de la tastatura
		System.out.println("Introduceti functiile");
		var=input.nextLine();
		input.close();
		
	//Prelucram colectia citita de la tastatura in variabila auxiliara aux
		aux=var;
		aux = aux.replace("[", "");
		aux = aux.replace("]", "");
		aux = aux.replace(" ", "");

	//De exemplu daca am citit de la tastatura [subtract_three, add_two, multiply_by_three] 
	//autnci vom avea in aux subtract_three,add_two,multiply_by_three
		

		System.out.print("[");
//functia indexOf returneaza pozitia caracterului , sau -1 in cazul in care aceasta nu se gaseste in strig
//Copiem din aux in aux3 caracterele pana la prima virgula si apoi taiem din aux partea copiata
		
		while (aux.indexOf(',') != -1) {
//la prima parcurgere daca aux este ="abc,def,ght" atunci aux3 devine "abc"
			aux3 = aux.substring(0, aux.indexOf(','));
//daca aux este "abc,def,ght" atunci devine "def,ght"
			aux = aux.substring(aux.indexOf(',') + 1, aux.length());

			if (verifica(aux3)) //verificam daca aux3 este o functie definita
				System.out.print(functie(aux3, n) + ", "); //daca este executam si afisam rezultatul
			else
				System.out.print("Functie nedefinita" + ", "); //altfel afisam functie nedefinita

		}
	//dupa ce am parcurs aux si am taiat pana nu au mai fost virgule ne-a ramas ultimul elemenet
		//de exemplu daca aux era ="abc,def,ght" atunci aux este acum "ght"
		if (verifica(aux))
			System.out.print(functie(aux, n));
		else
			System.out.print("Functie nedefinita");
		System.out.println("]");

	}
} 
