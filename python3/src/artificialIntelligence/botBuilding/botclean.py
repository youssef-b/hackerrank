"""
https://www.hackerrank.com/challenges/botclean
"""


# !/usr/bin/python

# Head ends here
def next_move(posr, posc, board):
    distance = 100
    neari = -1
    nearj = -1
    for i in range(5):
        for j in range(5):
            if board[i][j]=='d' and (((i - posr) ** 2 + (j - posc) ** 2) < distance):
                neari = i
                nearj = j
                distance = (i - posr) ** 2 + (j - posc) ** 2

    if neari == posr and nearj == posc:
        print("CLEAN")
    elif nearj < posc:
        print("LEFT")
    elif nearj > posc:
        print("RIGHT")
    elif neari < posr:
        print("UP")
    elif neari > posr:
        print("DOWN")


# Tail starts here
if __name__ == "__main__":
    pos = [int(i) for i in input().strip().split()]
    board = [[j for j in input().strip()] for i in range(5)]
    next_move(pos[0], pos[1], board)
