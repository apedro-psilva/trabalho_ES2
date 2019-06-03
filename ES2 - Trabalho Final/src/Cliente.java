import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.opencsv.CSVWriter;
import gestor.*;
import packageRepositorios.*;
import packageUtente.Utente;

public class Cliente {
	public static void main(String args[]) throws IOException {
		RepositorioDados rep = new RepositorioDados();
		RepositorioUtentes repU = new RepositorioUtentes();
		rep.iniRepositorioDados();
		repU.iniRepositorioUtentes();
		
		Escritor esc = new Escritor();
		esc.iniEscritor();
		
		Leitor l = new Leitor();
		l.iniLeitor();
		
		l.tabelaNutricional();
		

//		HashMap<String, String> info = rep.getAndPrintInfoCodigo("IS028");
//		System.out.println(info);
//		
//		ArrayList<String> a = rep.getAndPrintCodigosPorProduto("Leite");
//		System.out.println("\n" + a);	
//		
//		System.out.println(rep.getTabela());
		
		Integer c = 0;
		HashMap<Integer, String[]> teste = new HashMap<Integer, String[]>();
		
		for(String k: rep.getTabela().keySet()) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(k);
			for(String v: rep.getTabela().get(k).keySet()) {
				temp.add(rep.getTabela().get(k).get(v));
			}	
			teste.put(c, temp.toArray(new String[0]));
			c++;
		}
		
		esc.escreveFicheiro("", null, rep.getHeader(), teste);
		
		l.carregaFicheirosCSV();
		for(Utente u: repU.getUtentes())
			repU.printUtente(u.getId());
		
	}
}
