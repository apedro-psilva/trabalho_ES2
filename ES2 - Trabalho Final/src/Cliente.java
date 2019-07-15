import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyFolderException;
import exceptions.MissingFilesException;
import gestor.*;
import packageHabitosAlimentares.HabitosAlimentares;
import packageHabitosAlimentares.Produto;
import packageHabitosAlimentares.Refeicao;
import packageRepositorios.*;
import packageUtente.Utente;

public class Cliente {
	public static void main(String args[]) throws IOException, EmptyFolderException, MissingFilesException{
		RepositorioDados rep = RepositorioDados.iniRepositorioDados();
		RepositorioUtentes repU = RepositorioUtentes.iniRepositorioUtentes();

		Escritor esc = Escritor.iniEscritor();

		Leitor l = Leitor.iniLeitor();
		
		System.out.println(l.tabelaNutricional("src/Auxiliares/tabela_nutricional.txt"));

		System.out.println(l.lePasta("src/PastasTestesInputs/Inputs_Q_DF_HA_PP"));

		for(Utente u: repU.getUtentes()) {
			HashMap<Integer, String[]> dadosHAOutput = new HashMap<Integer, String[]>();
			HashMap<Integer, String[]> dadosPPOutput = new HashMap<Integer, String[]>();
			
			if(rep.getHabitosAlimentares(u.getId()) != null && rep.getPlanosAlimentares(u.getId()) != null) {
				esc.geraDados(0, u.getId(), rep.getHabitosAlimentares(u.getId()), dadosHAOutput);
				esc.geraDados(1, u.getId(), rep.getPlanosAlimentares(u.getId()), dadosPPOutput);
			}
		}
	} 


	
}
