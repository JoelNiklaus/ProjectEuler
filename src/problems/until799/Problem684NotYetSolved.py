from fractions import Fraction
import math
import operator
from functools import reduce
import timeit


def get_first_n_digits_str(num, num_digits):  # surprisingly, this is faster
    return int(str(num)[:num_digits])


def get_first_n_digits_math(num, num_digits): # surprisingly, this is slower
    # Find total number of digits - 1
    digits = int(math.log10(num))

    # Find first n digits
    return int(num / pow(10, digits - num_digits + 1))




def p(L, n):
    current_n = 0  # 1: smallest j, 2: second smallest j
    j = 1
    l_str = str(L)
    num_digits = len(l_str)
    while True:
        if get_first_n_digits_str(2 ** j, num_digits) == l_str:  # we found a j so that 2**j begins with L
            current_n += 1
            if current_n == n:  # we reached the n-th fitting j
                return j


assert p(12, 1) == 7
assert p(12, 2) == 80
#assert p(123, 45) == 12710
