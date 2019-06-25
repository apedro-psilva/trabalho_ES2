package exceptions;

public class EmptyFolderException extends Exception {
	private static final long serialVersionUID = -6869243930505213003L;
	public String mensagem = "Pasta especificada está vazia";

	public EmptyFolderException() {
    	System.out.println(mensagem);
    }
}
