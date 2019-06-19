package gestor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.opencsv.CSVWriter;

public class Escritor {
	File f1 = null, f2 = null;
	FileWriter writer = null;
	CSVWriter csvw = null;
	private static Escritor instance = null;

	public Escritor() {}

	public Escritor iniEscritor() {
		if(instance == null) {
			instance = new Escritor();
		}
		return instance;
	}

	public boolean escreveFicheiro(String tipo, int id, ArrayList<String> header, HashMap<Integer, String[]> dados) throws IOException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm");

		Date d = new Date();

		f1 = new File("src/Outputs/"+ tipo +"_" + id + "_" + df.format(d) + ".csv");

		try {
			writer = new FileWriter(f1);
			csvw = new CSVWriter(writer);

			if(!header.isEmpty()) {
				csvw.writeNext(header.toArray(new String[0]));
			}

			csvw.writeAll(dados.values());
		}
		catch(Exception e) {
			System.out.println("Erro a escrever para ficheiro: " + e);
			csvw.close();
			return false;
		}
		csvw.close();
		return true;
	}
}
