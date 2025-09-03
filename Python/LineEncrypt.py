from datetime import datetime
import hashlib
import os
from dotenv import load_dotenv

load_dotenv()

def file_reader_encrypt() -> str | list[str]:
    try:
        caminho_arquivo: str = os.getenv("ORIGINAL_MGS")
        with open(caminho_arquivo, 'r', encoding='utf-8') as arquivo:
            conteudo = arquivo.readlines()
        return conteudo
    except Exception as e:
        return f"===== Erro =====\n {e}"


def generate_file_encrypt(msg_encrypt: str, msg: str) -> str | bool:
    try:
        date = datetime.now().strftime("%d.%m.%Y    %H:%M:%S")
        caminho_arquivo = os.getenv("ENCRYPT_MGS")

        hash_object = hashlib.sha256()
        hash_object.update(msg[0].encode('utf-8'))
        hash_number = hash_object.hexdigest()
        print(msg_encrypt)

        with open(caminho_arquivo, 'w') as arquivo:
            arquivo.write(f"----- BEGIN ENCRYPTED MESSAGE -----\n"
                          f"Date:   {date}\n"
                          f"Lenght: {len(msg_encrypt)}\n"
                          f"Algorithm:   LineCrypt\n"
                          f"-----------------------------------\n\n")
            arquivo.write(msg_encrypt)

            arquivo.write("\n\n----- MESSAGE HASH -----\n")
            arquivo.write(hash_number)
        return True
    except Exception as erro:
        return f"===== Erro =====\n {erro}"
