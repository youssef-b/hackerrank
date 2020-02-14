"""
https://www.hackerrank.com/challenges/saveprincess
"""


#!/usr/bin/python
def displayPathtoPrincess(n,grid):

    for i in range(0,n):
        for j in range(0,n):
            if "p"==grid[i][j]:
                princessi=i
                princessj=j
            elif "m"==grid[i][j]:
                boti=i
                botj=j

    while(boti < princessi):
        print("DOWN")
        boti+=1
    while(boti > princessi):
        print("UP")
        boti-=1
    while(botj < princessj):
        print("RIGHT")
        botj+=1
    while(botj > princessj):
        print("LEFT")
        botj-=1

m = int(input())
grid = []
for i in range(0, m):
    grid.append(input().strip())

displayPathtoPrincess(m,grid)
