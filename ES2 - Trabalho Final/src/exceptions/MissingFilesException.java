package exceptions;

import java.util.ArrayList;

public class MissingFilesException extends Exception{
	private static final long serialVersionUID = 1L;
	public String mensagem = "";
	private ArrayList<String> tipos = new ArrayList<String>();
	
	public MissingFilesException(String fileQ, String fileHA, String fileDF, String filePP) {
		if(fileQ == null)
			tipos.add("Question�rio");
		
		if(fileDF == null)
			tipos.add("Dados Fisicos");
		
		if(fileHA == null)
			tipos.add("H�bitos Alimentares");
		
		if(filePP == null)
			tipos.add("Plano Prescrito");
		
		if(tipos.size() == 1)
			mensagem = tipos.get(0) + " n�o existe";
		else {
			for(String s: tipos) {
				mensagem += s + " ";
			}
			mensagem += "n�o existem";
		}
		
		System.out.println(mensagem);
    }
}
