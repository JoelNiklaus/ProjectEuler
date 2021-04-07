from fractions import Fraction
import math
import operator
from functools import reduce
import timeit
import numpy as np

limit = int(1e5)
#limit = int(1e12)

def merge_nums(num1, num2):
    return int(str(num1) + str(num2))



def merge_array(array: list, sums=None):
    if sums is None:
        sums = set()
    sums |= {int(np.sum(array))} # add sum of array to sums
    if len(array) == 2:  # end condition: at least 2 elements must remain
        return sums
    for pos in range(len(array) - 1):
        merged_number = merge_nums(array[pos], array[pos + 1])  # merge numbers to new one
        newly_merged_array = array.copy()
        newly_merged_array[pos] = merged_number # replace first old number
        del newly_merged_array[pos+1]  # remove second old number
        sums |= merge_array(newly_merged_array, sums)  # add
    return sums

digits = [int(x) for x in str(99225)]
merge_array(digits)

def run():
    sum = 0
    sqrt = 1
    square = 1
    run_counter = 0
    while square < limit:
        sqrt += 1
        square = sqrt ** 2
        digits = [int(x) for x in str(square)]
        sums = merge_array(digits)
        print(sqrt, square, sums)
        if sqrt in sums:
            sum += square
            print(sqrt, square, sums, "<===== found one!")
        run_counter += 1


    print(run_counter)
    print(square)
    print(sum)

run()