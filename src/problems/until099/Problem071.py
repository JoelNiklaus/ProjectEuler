from fractions import Fraction
import math
import operator

n = 1000000
fraction = Fraction(3, 7)

print("generating list")
list = []
for i in range(n):
    if i % 7 != 0:
        k_exact = fraction * i
        k_int = math.floor(k_exact)
        difference = (k_exact - k_int) / i
        if difference < 0.00001:
            list.append((Fraction(k_int, i), difference))

print("sorting list")
list.sort(key=operator.itemgetter(1))
print(list[0])
print(len(list))
