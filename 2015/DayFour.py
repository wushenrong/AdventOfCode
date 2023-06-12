#!/usr/bin/env python3

from hashlib import md5


def main():
    secret_key = input("Enter your secret key:\n")
    zeros = input("Enter zeros to compare the beginning of the hash with:\n")
    new_key = ""
    md5_hash = ""
    index = 0

    while md5_hash[:len(zeros)] != zeros:
        index += 1
        new_key = secret_key + str(index)
        md5_hash = md5(new_key.encode("utf-8")).hexdigest()

    print(f"Secret number: {index}\t Hash: {md5_hash}")


if __name__ == "__main__":
    main()
