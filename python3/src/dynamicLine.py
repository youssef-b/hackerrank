#!/bin/python3

import os
import sys

#
# Complete the dynamicLineIntersection function below.
#
def dynamicLineIntersection(n):
    qmax = 100001
    intersections = [0] * qmax

    for i in range(n):
        entry = input().split()
        if entry[0]=="+":
            k = int(entry[1])
            b = int(entry[2])
            for j in range(int(-b/k), int((qmax-b)/k)):
                intersections[b+j*k] += 1

        elif entry[0]=="-":
            k = int(entry[1])
            b = int(entry[2])
            for j in range(int(-b/k), int((qmax+1-b)/k)):
                intersections[b+j*k] -= 1

        elif entry[0]=="?":
            q = int(entry[1])
            print(str(intersections[q]))

if __name__ == '__main__':
    n = int(input())

    dynamicLineIntersection(n)
