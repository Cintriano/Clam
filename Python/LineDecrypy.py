from datetime import datetime
import hashlib
import os
from Coding import coding
from dotenv import load_dotenv

load_dotenv()

def file_reader_decrypt() -> tuple[str, Exception] | list[list[str]]:
    """
    Leitura do Arquivo cifrado, também prepara a mensagem para o resto do código, eliminando
    o cabeçalho e o hash.
        """
    conteudo: list[list[str]] = []
    try:
        caminho_arquivo: str = os.getenv("ENCRYPT_MGS")
        with open(caminho_arquivo, 'r') as arquivo:
            msg_only: list[str] = arquivo.readlines()[6:-3]
            for linha in msg_only:
                line_list: list[str] = linha.split("\t")
                clean_list: list[str] = line_list[0:-1]
                clean_list.append(line_list[-1].replace("\n", ""))
                conteudo.append(clean_list)
        return conteudo
    except Exception as e:
        return "===== Erro =====\n", e


def generate_file_decrypt(conteudo: str) -> tuple[str, Exception] | bool:
    """
    Responsavel por criar o arquivo com a mensagem descifrada.
    """
    try:
        caminho_arquivo: str = os.getenv("DECRYPT_MGS")
        date = datetime.now().strftime("%d.%m.%Y    %H:%M:%S")

        hash_object = hashlib.sha256()
        hash_object.update(conteudo.encode('utf-8'))
        hash_number = hash_object.hexdigest()

        with open(caminho_arquivo, 'w', encoding='utf-8') as arquivo:
            arquivo.write(f"----- BEGIN ENCRYPTED MESSAGE -----\n"
                          f"Date:   {date}\n"
                          f"Lenght: {len(conteudo)}\n"
                          f"Algorithm:   LineCrypt\n"
                          f"-----------------------------------\n\n")
            arquivo.write(conteudo)

            arquivo.write("\n\n----- MESSAGE HASH -----\n")
            arquivo.write(hash_number)
        return True
    except Exception as e:
        return "===== Erro =====\n", e


def keys_format(keys: str) -> list[str]:
    """
    Extrai as chaves da mensagem codificada.
    """
    keys_list: list[str] = keys.split(" ")
    keys_list.remove("")
    return [coding(keys_list[0], "chave"), coding(keys_list[1], "chave")]
