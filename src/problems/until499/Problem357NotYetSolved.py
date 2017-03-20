from fractions import Fraction
import math
import operator
from functools import reduce


n = 100000000

def factors(n):
    return set(reduce(list.__add__, ([i, n // i] for i in range(1, int(n ** 0.5) + 1) if n % i == 0)))



print(factors(332))


