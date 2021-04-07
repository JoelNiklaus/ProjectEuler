from fractions import Fraction
import math
import operator
from functools import reduce
import timeit

factor = 1504170715041707
# factor = 15041707
# factor = 1504
mod = 4503599627370517
# mod = 45035996
# mod = 4503


def compute_term(n):
    return n * factor % mod


def is_euler_coin(term, smallest_euler_coin):
    return term < smallest_euler_coin


smallest_euler_coin = factor
sum = factor  # the factor will be added in the last iteration
n = 2
term = compute_term(n)
while smallest_euler_coin >= 0 and term != factor:  # compute until we are at the start of the ring again
#for i in range(1000):
    n += 1
    term = compute_term(n)
    #print(f"{n}: {n * factor} % {mod} = {term}")
    if is_euler_coin(term, smallest_euler_coin):
        sum += term
        smallest_euler_coin = term
        print(n, term)
        #n += int(n * 0.5)

print(sum)
