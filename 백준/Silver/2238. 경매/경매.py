import sys
input = sys.stdin.readline

U,N = map(int,input().split())
p = [[] for _ in range(10001)]
num = [0 for _ in range(10001)]
m = 10001
for _ in range(N):
    name, price = input().split()
    price = int(price)
    p[price].append(name) # 가격별 경매인원 정리
    num[price] += 1 # 가격별 경매인원 카운트
for i in range(10001): 
    if num[i] != 0:  #최소 경매인원이 몇명인지
        m = min(num[i],m)
for i in range(10001): # 최소 경매인원이 있는 가장 낮은 가격을 찾는다.
    if m == num[i]:
        print(p[i][0],i)
        break