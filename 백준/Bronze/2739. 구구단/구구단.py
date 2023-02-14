N = int(input()) # 첫째 줄에 N이 주어진다. (1 <= N <= 9)

for i in range(1, 10) :
    print(N, "*", i, "=", N * i, sep = " ")