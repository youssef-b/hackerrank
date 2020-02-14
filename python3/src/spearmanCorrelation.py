
n = int(input())
X = [float(i) for i in input().split()]
Y = [float(i) for i in input().split()]

def get_rank(X):
    x_rank = dict((x, i+1) for i, x in enumerate(sorted(X)))
    return [x_rank[x] for x in X]

rx = get_rank(X)
ry = get_rank(Y)

d = [(rx[i] -ry[i])**2 for i in range(n)]
rxy = 1 - (6 * sum(d)) / (n * (n*n - 1))

print('%.3f' % rxy)
