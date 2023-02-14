# A＠B = (A + B)×(A - B)
N, X = input().split()

N = int(N)
X = int(X)

num = input().split()

for i in range(N) :
    num[i] = int(num[i])
    if num[i] < X :
        print(num[i], end = " ")
