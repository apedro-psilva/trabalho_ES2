import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import packageAutenticacao.Autenticacao;
import packageUtente.*;
import packageQuestionario.Questionario;
import packageRepositorios.*;
import packageHabitosAlimentares.HabitosAlimentares;

public class Cliente {
	public static void main(String args[]) {
		File folder = new File("src/inputs");
		File [] listaFicheiros = folder.listFiles();
		Scanner input = new Scanner(System.in);
		String id = null;
		String data = null;
		int counter = 0;
		File f = null;
		
		if(listaFicheiros.length > 0) {
			try {
				System.out.println("Qual o id do Utente?");
				id = input.nextLine();
				
				if(listaFicheiros.length > 1 ) {
					System.out.println("\nQual o ficheiro que quer?");
					for(int i = 0; i < listaFicheiros.length; i++ ) {
						if(listaFicheiros[i].isFile() && listaFicheiros[i].getName().split("_")[0].equals("PA") && listaFicheiros[i].getName().split("_")[1].equals(id)) {
							System.out.println(counter + " - " + listaFicheiros[i].getName());
							counter++;
						}
					}

					String e = input.nextLine();
					
					data = listaFicheiros[Integer.parseInt(e)].getName().split("\\.")[0].split("_")[2];
					f = new File(listaFicheiros[Integer.parseInt(e)].getPath());
				} else {
					data = listaFicheiros[0].getName().split("\\.")[0].split("_")[2];
					f = new File(listaFicheiros[0].getPath());
				}
				
				BufferedReader temp = new BufferedReader(new FileReader(f));
				String linha = null;
				HashMap<Integer,ArrayList<String>> campos = new HashMap<Integer,ArrayList<String>>();
				counter = 0;
				
				while((linha = temp.readLine())!= null) {
					ArrayList<String> l = new ArrayList<String>();
					counter++;
					
					for(String c: linha.split(",")) {
						l.add(c);
					}
					
					campos.put(counter, l);
				}
				
				for(int k = 1; k <= campos.size(); k++) {
					if(k == 1) {
						System.out.println("\n\nUtente: " + id + "\nData do ficheiro: " + data);
						System.out.println("\n" + campos.get(k).get(0) + ": " + campos.get(k).get(1) + "h");
					} else {
						for(int s = 0; s < campos.get(k).size(); s++) {
							if(s == 0) {
								System.out.print("\n" + campos.get(k).get(s) + " - ");
							} 
							else if(s == 1) {
								System.out.println(campos.get(k).get(s) + "h\n");
							}
							else {
								if(s%2 == 0) {
									System.out.print("\t\t"+ campos.get(k).get(s) + " - ");
								} else {
									System.out.println(campos.get(k).get(s).split("_")[0] + " " + campos.get(k).get(s).split("_")[1]);
								}
							}
							
						}
						
					}
				}
				
			} catch (Exception e) {
				System.out.println("Erro a ler linhas: " + e);
			}
		}
		
	}
}
