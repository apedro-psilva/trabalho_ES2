package exceptions;

import java.util.ArrayList;

public class MissingFilesException extends Exception{
	private static final long serialVersionUID = 1L;
	public String mensagem = "";
	private ArrayList<String> tipos = new ArrayList<String>();
	
	public MissingFilesException(String fileQ, String fileHA, String fileDF, String filePP) {
		if(fileQ == null)
			tipos.add("Questionário");
		
		if(fileHA == null)
			tipos.add("Hábitos Alimentares");
		
		if(fileDF == null)
			tipos.add("Dados Fisicos");
		
		if(filePP == null)
			tipos.add("Plano Prescrito");
		
		if(tipos.size() == 1)
			mensagem = tipos.get(0) + " não existem.";
		else {
			for(String s: tipos) {
				mensagem += s + " ";
			}
			mensagem += " não existem.";
		}
		
		System.out.println(mensagem);
    }
}
