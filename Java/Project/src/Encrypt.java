package clam;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;


public class Encrypt {
	
	public static void gerador_arquivo_encrypt(String conteudo) {
		String caminhoArquivo = "C:\\Users\\danil\\OneDrive\\Arquivos\\Projetos\\Clam\\Java\\Project\\src\\msg_encrypt.txt";
		LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy	HH:mm:ss");

	    try {
	            BufferedWriter arquivo = new BufferedWriter(new FileWriter(caminhoArquivo));
	            
	            arquivo.write("----- BEGIN ENCRYPTED MESSAGE -----\n");
	            arquivo.write("Date:	" + date.format(formatter) + "\n");
	            arquivo.write("Lenght:	" + conteudo.length() + "\n");
	            arquivo.write("Algorithm: LineCrypt\n");
	            arquivo.write("-----------------------------------\n\n");
	            
	            String hash = hash_generador(leitor_arquivo().get(0));
	            
	            arquivo.write(conteudo);
	            arquivo.newLine();
	            
	            arquivo.write("\n----- MESSAGE HASH -----\n");
	            arquivo.write(hash + "\n");
	            
	            arquivo.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
	        }
	}
	
	public static String hash_generador(String msg) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = digest.digest(msg.getBytes(StandardCharsets.UTF_8));
	        
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hashBytes) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Erro ao gerar hash SHA-256", e);
	    }
	}



	public static List<String> leitor_arquivo() throws IOException {
		List<String> passwords = new ArrayList<>();
		String caminho = "C:\\Users\\danil\\OneDrive\\Arquivos\\Projetos\\Clam\\Java\\Project\\src\\msg.txt";

        try {
            File file = new File(caminho);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String linha;
            while ((linha = reader.readLine()) != null) {
                passwords.add(linha);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passwords;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		List<String> password_list = new ArrayList<>();
		
		password_list = leitor_arquivo();
		Integer aux = 0;
		String msg_encrypt = "";
		List<String> key = Math.keys();
		
		for (String password : password_list) {
			for (int i = 0; i < password.length(); i++) {
				String code = Coding.coding(password.substring(i, i + 1), "chave");
				if (aux == 15) {
					msg_encrypt = msg_encrypt + Coding.coding(key.get(0), "chave") + "  " + Coding.coding(key.get(1), "chave");
					msg_encrypt = msg_encrypt + "\n";
					key = Math.keys(); 
					aux = 0;
				}
				aux++;
				msg_encrypt = msg_encrypt + Math.mathing(code, key) + "	";
			}
		}
		msg_encrypt = msg_encrypt + Coding.coding(key.get(0), "chave") + "  " + Coding.coding(key.get(1), "chave");
		gerador_arquivo_encrypt(msg_encrypt);
	}
}