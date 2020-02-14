"""
https://www.hackerrank.com/challenges/stockprediction/problem
"""

# !/bin/python3

def printTransactions(m, k, d, name, owned, prices):
    transactions = []
    for i in range(0, k):
        if owned[i] > 0:
            if prices[i][4] > max(prices[i][0:4]):
                transactions.append(name[i] + " SELL " + str(owned[i]))

    decreasingStocks = []
    for i in range(0, k):
        minp = min(prices[i][0:4])
        if prices[i][4] < minp:
            decRate = (minp - prices[i][4]) / prices[i][4]
            decreasingStocks.append((decRate, i))

    decreasingStocks.sort(reverse=True)

    for (dec, i) in decreasingStocks:
        maxBuy = int(float(m) / prices[i][4])
        m -= maxBuy * prices[i][4]
        if maxBuy > 0:
            transactions.append(name[i] + " BUY " + str(maxBuy))

    print(str(len(transactions)))
    for transac in transactions:
        print(transac)


if __name__ == '__main__':
    m, k, d = [float(i) for i in input().strip().split()]
    k = int(k)
    d = int(d)
    names = []
    owned = []
    prices = []
    for data in range(k):
        temp = input().strip().split()
        names.append(temp[0])
        owned.append(int(temp[1]))
        prices.append([float(i) for i in temp[2:7]])

    printTransactions(m, k, d, names, owned, prices)
