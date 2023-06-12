#!/usr/bin/env python3

def old_rules(file_handler):
    DISALLOWED_STRINGS = ["ab", "cd", "pq", "xy"]
    VOWELS = ["a", "e", "i", "o", "u"]

    num_of_nice_strings = 0

    for string in file_handler:
        num_of_vowels = 0
        has_double_letters = False

        if any(disallowed in string for disallowed in DISALLOWED_STRINGS):
            continue

        for i, character in enumerate(string):
            if character == string[i+1:i+2]:
                has_double_letters = True

            if character in VOWELS:
                num_of_vowels += 1

        if num_of_vowels >= 3 and has_double_letters:
            num_of_nice_strings += 1

    return num_of_nice_strings


def new_rules(file_handler):
    num_of_nice_strings = 0

    for string in file_handler:
        pair_appear_twice = False
        has_double_letters_with_gap = False

        for i, character in enumerate(string):
            if character == string[i+2:i+3]:
                has_double_letters_with_gap = True

            if string[i:i+2] in string[i+2:]:
                pair_appear_twice = True

        if pair_appear_twice and has_double_letters_with_gap:
            num_of_nice_strings += 1

    return num_of_nice_strings


def main():
    with open("DayFive.txt", "r", encoding="utf-8") as f:
        print(f"Number of nice strings with old rules: {old_rules(f)}")
        print(f"Number of nice strings with new rules: {new_rules(f)}")


if __name__ == "__main__":
    main()
