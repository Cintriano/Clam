import unicodedata

caracteres = {
        " ": "8163",

        "A": "1234", "B": "5678", "C": "9012", "D": "3456", "E": "7890", "F": "1357", "G": "2468", "H": "3579",
        "I": "4680", "J": "5791", "K": "6802", "L": "7913", "M": "8024", "N": "9135", "O": "8246", "P": "1358",
        "Q": "2469", "R": "3590", "S": "4681", "T": "5792", "U": "6803", "V": "7914", "Y": "8025", "Z": "9136",
        "X": "4353",

        "a": "2577", "b": "7615", "c": "2900", "d": "2883", "e": "9535", "f": "7225", "g": "3584", "h": "7208",
        "i": "1366", "j": "7550", "k": "7199", "l": "7759", "m": "6328", "n": "1764", "o": "2066", "p": "7380",
        "q": "6130", "r": "2010", "s": "9691", "t": "1052", "u": "2143", "v": "4774", "y": "4332", "z": "1453",
        "x": "2353",

        "0": "1230", "1": "2341", "2": "3452", "3": "4563", "4": "5674", "5": "6785", "6": "7896", "7": "8907",
        "8": "9018", "9": "0129", "10": "5372", "11": "6245", "12": "7821", "13": "5107", "14": "9873", "15": "2475",
        "16": "6021", "17": "1294", "18": "3782", "19": "7491", "20": "5738", "21": "6724", "22": "3180", "23": "8291",
        "24": "5486", "25": "9236", "26": "6719", "27": "2148", "28": "3802", "29": "1489", "30": "7950", "31": "6432",
        "32": "9526", "33": "1769", "34": "2513", "35": "6823", "36": "2945", "37": "3796", "38": "8472", "39": "5319",
        "40": "1635", "41": "2309", "42": "4910", "43": "8471", "44": "2839", "45": "9482", "46": "5243", "47": "8365",
        "48": "4957", "49": "7123", "50": "8096", "51": "3721", "52": "6953", "53": "5186", "54": "4230", "55": "1749",
        "56": "2653", "57": "7432", "58": "9235", "59": "6734", "60": "1825", "61": "4036", "62": "5912", "63": "8947",
        "64": "7461", "65": "2580", "66": "5043", "67": "9701", "68": "1478", "69": "6430", "70": "3052", "71": "5073",
        "72": "6891", "73": "9452", "74": "1762", "75": "6279", "76": "3158", "77": "7489", "78": "9237", "79": "2714",
        "80": "5471", "81": "8732", "82": "2564", "83": "6385", "84": "4917", "85": "2640", "86": "1756", "87": "3905",
        "88": "6842", "89": "7390", "90": "7361", "91": "1945", "92": "7054", "93": "3107", "94": "9573", "95": "6142",
        "96": "2894", "97": "4531", "98": "2879", "99": "7349", "100": "2589",

        "!": "1111", "@": "2222", "#": "3333", "$": "4444", "%": "5555", "&": "6666", "*": "7777", "+": "8888",
        "-": "8854","=": "9999", "<": "1010", ">": "2020", "?": "3030", "/": "4040", "\\": "5050", "|": "6060",
        ":": "7070", ";": "8080", "(": "9091", ")": "9090", ",": "9094", ".": "9097", "_": "4854", "\n":"4326",

        "Á": "1112", "À": "2223", "Â": "3334", "Ã": "4445", "É": "5556", "Ê": "6667", "Í": "7778", "Ó": "8889",
        "Ò": "9991", "Ô": "1012", "Õ": "2023", "Ú": "3034", "Ü": "4045","Ç": "5056", "á": "6161", "à": "7272",
        "â": "8383", "ã": "9494", "é": "1515", "ê": "2626", "í": "3737", "ó": "4848","ò": "5959", "ô": "6061",
        "õ": "7172", "ú": "8283", "ü": "9394", "ç": "1414"
    }


def coding(msg, indice):
    if indice == "valor":
        return caracteres.get(msg)
    elif indice == "chave":
        for chave, valor in caracteres.items():
            if valor == msg:
                return chave
    print("Valor não encontrado")
    return None


def normalizacao(msg: list[str]) -> bool or str:
    """
    Normaliza a mensagem, removendo os acentos, recebendo a string completa
    da mensagem e retornando ela normalizada
    """
    msg_normalizada = []
    try:
        for line in msg:
            conteudo_normalizado = unicodedata.normalize('NFD', line)

            linha_sem_acentos = ''.join(
                c for c in conteudo_normalizado
                if unicodedata.category(c) != 'Mn'
            )

            msg_normalizada.append(linha_sem_acentos)
        print(msg_normalizada)
        return msg_normalizada
    except Exception as erro:
        return f"===== Erro =====\n {erro}"

def normalizacao_2(msg: list[str])-> bool or str:
    msg_normalizada = []
    try:
        for line in msg:
            line = line.replace("á", "a")
            line.replace("à", "a")
            line.replace("â", "a")
            line.replace("ã", "a")

            line.replace("é", "e")
            line.replace("è", "e")
            line.replace("ê", "e")

            line.replace("í", "i")
            line.replace("ì", "i")

            line.replace("õ", "o")
            line.replace("ô", "o")
            line.replace("ó", "o")
            line.replace("ò", "o")

            line.replace("ú", "u")
            line.replace("ù", "u")
            line.replace("û", "u")

            line.replace("ç", "c")
        return msg_normalizada
    except Exception as erro:
        return f"===== Erro =====\n {erro}"


def valid_caracteres(msg: list[str]) -> bool:
    """
    Verifica se todos os caracteres da mensagem existem no dicionário do sistema.
    A função deve receber uma lista que cada elemenro é um caractere apenas
    """
    for line in msg:
        for caractere in line:
            if caractere not in caracteres:
                print(f"===== Erro =====\nCaractere '{caractere}' não encontrado no dicionário.")
                return False
    return True
