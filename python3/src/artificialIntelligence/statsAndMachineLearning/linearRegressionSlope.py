"""
https://www.hackerrank.com/challenges/correlation-and-regression-lines-7/problem
"""

#!/bin/python3


a = [15, 12, 8, 8, 7, 7, 7, 6, 5, 3]
b = [10, 25, 17, 11, 13, 17, 20, 13, 9, 15]


def average(x):
    assert len(x) > 0
    return float(sum(x)) / len(x)


def regression_slope(x, y):
    assert len(x) == len(y)
    n = len(x)
    assert n > 0
    avg_x = average(x)
    avg_y = average(y)
    diffprod = 0
    xdiff2 = 0
    for idx in range(n):
        xdiff = x[idx] - avg_x
        ydiff = y[idx] - avg_y
        diffprod += xdiff * ydiff
        xdiff2 += xdiff * xdiff

    return diffprod /xdiff2


print('{:.3f}'.format(regression_slope(a, b)))
