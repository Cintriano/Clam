import random

def mathing(msg: str, key_a: str, key_b: str) -> str:
    code = int(msg)
    a = int(key_a)
    b = int(key_b)
    msg_encrypt = (code * b) + a
    return str(msg_encrypt)


def unmathing(msg: str, key_a: str, key_b: str) -> str:
    code = int(msg)
    a = int(key_a)
    b = int(key_b)
    msg_dencrypt = (code - a) / b
    return str(int(msg_dencrypt))


def keys_generate() -> list[str]:
    key_a: int = random.randint(1, 100)
    key_b: int = random.randint(1, 100)
    return [str(key_a), str(key_b)]