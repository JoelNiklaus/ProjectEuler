def triangle(n):
    return int(n * (n + 1) / 2)


def square(n):
    return n * n


def pentagonal(n):
    return int(n * (3 * n - 1) / 2)


def hexagonal(n):
    return int(n * (2 * n - 1))


def heptagonal(n):
    return int(n * (5 * n - 3) / 2)


def octagonal(n):
    return n * (3 * n - 2)


def get_polygon_numbers(polygon_gen):
    numbers = []
    i = 1
    while polygon_gen(i) < 10000:
        if polygon_gen(i) >= 1000:
            numbers.append(polygon_gen(i))
        i += 1
    print(len(numbers))
    print(numbers)
    return numbers


def get_start(num):
    """
       returns the first two digits of a four digit number
    """
    return int(str(num)[:2])


def get_end(num):
    """
    returns the last two digits of a four digit number
    """
    return int(str(num)[2:])


# polygons = ['triangles', 'squares', 'pentagons', 'hexagons', 'heptagons', 'octagons']

polygons = [get_polygon_numbers(triangle),
            get_polygon_numbers(square),
            get_polygon_numbers(pentagonal),
            get_polygon_numbers(hexagonal),
            get_polygon_numbers(heptagonal),
            get_polygon_numbers(octagonal)]

print(polygons)


def search_tree(original_start=None, previous_end=None, polygons_to_visit=None, numbers_visited=None):
    for polygon in polygons_to_visit:  # visit all the polygon categories (triangles, squares, etc.)
        for num in polygons[polygon]:  # visit all of the numbers in the current polygon category
            if get_start(num) == previous_end:  # if the current start matches with the previous end
                # if the original start matches with the current end and we are visiting the last polygon
                if original_start == get_end(num) and len(polygons_to_visit) == 1:
                    new_numbers_visited = numbers_visited + [num]  # add the current num to the path
                    return new_numbers_visited  # end the recursion: return the numbers we found on the path
                new_polygons_to_visit = list(polygons_to_visit)  # copy the list
                new_polygons_to_visit.remove(polygon)  # mark the current polygon category as visited
                new_numbers_visited = list(numbers_visited)  # copy the list
                new_numbers_visited.append(num)  # add the current num to the path
                path = search_tree(original_start, get_end(num), new_polygons_to_visit, new_numbers_visited)  # Recursion
                if path is None:
                    continue  # prevent the recursion from going back to the root. only search from the parent node
                else:
                    return path
    return None


for number in polygons[0]:  # start with the triangles
    path = search_tree(get_start(number), get_end(number), list(range(1, 6)), [number])
    if path is not None:
        print(path)
        print(sum(path))
