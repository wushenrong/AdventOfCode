#!/usr/bin/env python3

def main():
    final_floor = 0
    reached_basement = False
    position_to_basement = 0

    with open("DayOne.txt", "r", encoding="utf-8") as f:
        instructions = f.read()

        for instruction in instructions:
            if instruction == "(":
                final_floor += 1
            elif instruction == ")":
                final_floor -= 1

            if not reached_basement:
                position_to_basement += 1

            if final_floor == -1:
                reached_basement = True

    print(f"Floor that santa reached: {final_floor}")
    print(f"Position which santa reached basement: {position_to_basement}")


if __name__ == "__main__":
    main()
