import re
"""
0 1 2 3 4 5 6 7 8 9 Q!
W@ E# R$ T% Y U I L P Z
Q!3 = (10x20^1 + 3x20^0)
"""


def vigesimal_decimal(vigesimal_numero) -> float:
    dic_algarism = {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9,
                    "Q!": 10, "W@": 11, "E#": 12, "R$": 13, "T%": 14, "Y": 15,
                    "U": 16, "I": 17, "L": 18, "P": 19, "Z": 20}

    padroes = ["Q!", "W@", "E#", "R$", "T%", "Y", "U", "I", "L", "P", "Z"]

    # Criar um padrão de regex que busca os padrões exatos OU números
    regex = r'(' + '|'.join(map(re.escape, padroes)) + r'|[0-9])'
    list_algarism: list[str] = list(reversed(re.findall(regex, vigesimal_numero)))
    potencia = 0
    final_num = 0
    for algarism in list_algarism:
        number = dic_algarism.get(algarism)
        final_num = final_num + number * (20 ** potencia)
        potencia += 1
    return final_num

def vigesialEncrypt(numero_str: str = "1325") -> float:
    numero_reverso = reversed(numero_str)
    list_numeros = []

    cs_decimal = 1
    for alg in numero_reverso:
        numero = float(alg)
        list_numeros.append(numero * cs_decimal)
        cs_decimal = cs_decimal * 10

    exp = 0
    for numero in list_numeros:
        soma = soma + (numero * (20 ** exp))
        exp += 1
    print(soma)



if __name__ == "__main__":
    num = "1Q!"
    #print(vigesimal_decimal(num))
    vigesialEncrypt()