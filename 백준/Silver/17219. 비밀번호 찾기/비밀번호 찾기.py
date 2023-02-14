import sys
N, M = map(int, sys.stdin.readline().split())
dic = {}

for i in range(N) :
    site = sys.stdin.readline().split()
    dic[site[0]] = site[1]

for i in range(M) :
    print(dic[input()])