#!/usr/bin/env python3

def main():
    total_wrapping_paper = 0
    total_ribbon = 0

    with open("DayTwo.txt", "r", encoding="utf-8") as f:
        for dimension in f:
            length, width, height = dimension.rstrip().split(sep="x")
            length = int(length)
            width = int(width)
            height = int(height)

            side_area_lw = length * width
            side_area_wh = width * height
            side_area_lh = length * height

            surface_area = (2 * side_area_lw) + \
                (2 * side_area_wh) + (2 * side_area_lh)
            surface_area += min(side_area_lw, side_area_wh, side_area_lh)
            total_wrapping_paper += surface_area

            ribbon = 0
            min_side_one = 0
            min_side_two = 0

            if length < width:
                min_side_one = length
            else:
                min_side_one = width

            if length < height:
                min_side_two = length
            else:
                min_side_two = height

            if min_side_one is length and min_side_two is length:
                if width < height:
                    min_side_two = width
                else:
                    min_side_two = height

            ribbon += (2 * min_side_one) + (2 * min_side_two)
            ribbon += length * width * height
            total_ribbon += ribbon

    print(
        f"Total square feet of wrapping paper needed: {total_wrapping_paper}")
    print(f"Total feet of ribbon needed: {total_ribbon}")


if __name__ == "__main__":
    main()
