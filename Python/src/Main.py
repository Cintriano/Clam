from Math import *
from Python.src.Coding import *
from Python.src.LineEncrypt import *
from Python.src.LineDecrypy import *

def lineEncrypt() -> str:
    msg_encrypt: str = ""
    cont_caracteres = 0  # Conta as linhas da menssagem

    keys = keys_generate() # Gera chaves para ser usadas na cifra
    list_lines_msg = file_reader_encrypt() # Chama a função que
    msg_normalizada = normalizacao(list_lines_msg)

    if not valid_caracteres(msg_normalizada):
        return "Erro na validação dos caracteres"

    for line in list_lines_msg:
        for caracter in line:
            caracter_code = coding(caracter, "valor")
            if cont_caracteres == 15:
                msg_encrypt = msg_encrypt + coding(str(keys[0]), "valor") + "  " + coding(str(keys[1]), "valor") + "\n"
                keys = keys_generate()
            cont_caracteres += 1
            msg_encrypt = msg_encrypt + mathing(caracter_code, keys[0], keys[1]) + "	"

    msg_encrypt = msg_encrypt + coding(str(keys[0]), "valor") + "  " + coding(str(keys[1]), "valor")
    generate_file_encrypt(msg_encrypt, list_lines_msg)
    return "========== Criptografia Concluida =========="


def LineDecrypt() -> str:
    conteudo: str = ''
    encrypt_msg = file_reader_decrypt()
    for linha in encrypt_msg:
        msg_only = linha[0:-1]
        keys = keys_format(linha[-1])
        for num in msg_only:
            num_cod = unmathing(num, keys[0], keys[1])
            conteudo = conteudo + coding(num_cod, "chave")
    generate_file_decrypt(conteudo)
    return "========== Descriptografia Concluida =========="


if __name__ == "__main__":
    print(
        """
        Escolha a função requerida
        e - Encrypt
        d - Decrypt
        """)

    aux = True

    while aux:
        op = input("Digite a opção: ")
        if op == "e":
            print(
                """
                Escolha no algoritmo de cifra
                1 - LineEncrypt
                2 - none
                """)
            print(lineEncrypt())
            aux = False
        elif op == "d":
            print(LineDecrypt())
            aux = False
        else:
            print("Opção invalida, digite novamente")
