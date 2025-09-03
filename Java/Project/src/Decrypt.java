package clam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decrypt {
	
	public static List<List<String>> leitor_arquivo() {
	    List<List<String>> linhas = new ArrayList<>();
	    String caminho = "C:\\Users\\danil\\OneDrive\\Arquivos\\Projetos\\Clam\\Java\\Project\\src\\msg_encrypt.txt";

	    try {
	        File file = new File(caminho);
	        BufferedReader reader = new BufferedReader(new FileReader(file));

	        String linha;
	        while ((linha = reader.readLine()) != null) {
	            String[] numbers = linha.split("	");
	            List<String> linhaLista = Arrays.asList(numbers);
	            linhas.add(linhaLista);
	        }

	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return linhas;
	}
	
	public static void gerador_arquivo_decrypt(String conteudo) {
		String caminhoArquivo = "C:\\Users\\danil\\OneDrive\\Arquivos\\Projetos\\Clam\\Java\\Project\\src\\msg_decrypt.txt";
		LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy	HH:mm:ss");

	    try {
	            BufferedWriter arquivo = new BufferedWriter(new FileWriter(caminhoArquivo));
	            
	            arquivo.write("----- BEGIN DECRYPTED MESSAGE -----\n");
	            arquivo.write("Date:	" + date.format(formatter) + "\n");
	            arquivo.write("Lenght:	" + conteudo.length() + "\n");
	            arquivo.write("Algorithm: LineCrypt\n");
	            arquivo.write("-----------------------------------\n\n");
	            
	            String hash = Encrypt.hash_generador(conteudo);
	            
	            arquivo.write(conteudo);
	            arquivo.newLine();
	            
	            arquivo.write("\n----- MESSAGE HASH -----\n");
	            arquivo.write(hash + "\n");
	            
	            arquivo.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
	        }
	}
	
	public static List<Integer> keys_reader(List<String> number) {
		
		List<Integer> keys_list = new ArrayList<>();
		String keys = number.get(number.size() - 1);
		    
		String[] keys_split = keys.split("  ");
		
		String A = Coding.coding(keys_split[0], "valor");
		String B = Coding.coding(keys_split[1], "valor");

        keys_list.add(Integer.parseInt(A));
        keys_list.add(Integer.parseInt(B));
            
		return keys_list;
	}
	
	public static Boolean validate_hash(String msg) {
		String new_hash = Encrypt.hash_generador(msg);
		List<List<String>> arquivo = leitor_arquivo();
		List<String> old_hash = arquivo.get(arquivo.size() -1);
		
		if (new_hash.equals(old_hash.get(0))) {
			return true;
		}
		return false;
		
	}

	
	public static void main(String[] args) throws IOException {
		List<List<String>> arquivo = leitor_arquivo();
		List<List<String>> list_numbers = arquivo.subList(6, arquivo.size() - 3);
		String msg_decrypt = "";
		
		for (List<String> number : list_numbers) {
			List<String> msg = number.subList(0, number.size() - 1);
			for (String caractere : msg) {
				String resultado = Math.unmath(caractere,keys_reader(number));
				msg_decrypt = msg_decrypt + Coding.coding(resultado, "valor");
				
			}
		}
		gerador_arquivo_decrypt(msg_decrypt);
		
		System.out.print("Validação do hash: ");
		System.out.print(validate_hash(msg_decrypt));
	}
}
