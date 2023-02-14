N = int(input())

A = set(map(int, input().split()))

checkNum = input().split()

arr = list(map(int, input().split()))

for i in arr :
    print(1) if i in A else print(0)