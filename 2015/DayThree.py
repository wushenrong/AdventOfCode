#!/usr/bin/env python3


def move(position, direction):
    if direction == "<":
        position[0] -= 1
    elif direction == ">":
        position[0] += 1
    elif direction == "v":
        position[1] -= 1
    elif direction == "^":
        position[1] += 1


def santa_only(directions):
    unique_house = 0
    previous_locations = []
    position = [0, 0]

    for direction in directions:
        move(position, direction)

        current_position = tuple(position)

        if current_position not in previous_locations:
            previous_locations.append(current_position)
            unique_house += 1

    return unique_house


def with_robo(directions):
    unique_house = 0
    previous_locations = []
    santa_position = [0, 0]
    robo_position = [0, 0]

    for i, direction in enumerate(directions):
        current_position = ()

        if i % 2 == 0:
            move(santa_position, direction)
            current_position = tuple(santa_position)
        else:
            move(robo_position, direction)
            current_position = tuple(robo_position)

        if current_position not in previous_locations:
            previous_locations.append(current_position)
            unique_house += 1

    return unique_house


def main():
    with open("DayThree.txt", "r", encoding="utf-8") as f:
        directions = f.read()

        print(f"Number of unique houses for santa: {santa_only(directions)}")
        print(
            f"Number of unique houses with robo-santa: {with_robo(directions)}")


if __name__ == "__main__":
    main()
