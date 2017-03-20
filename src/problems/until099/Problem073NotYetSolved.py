from fractions import Fraction
import math
import operator

d_final = 8

set = set()

for d in range(d_final + 1):
    n_min = math.floor(d / 3 + 1)
    n_max = math.ceil(d / 2 - 1) + 1
    for n in range(n_min, n_max):
        set.add(Fraction(n, d))

print(set)
print(len(set))
