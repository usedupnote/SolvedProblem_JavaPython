import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

computer = [0 for _ in range(N+1)]

def makeSet() :
    for i in range(N+1) :
        computer[i] = i

def union(a, b) :
    if computer[a] == computer[b] :
        return

    computer[a] = findSet(a)
    computer[b] = findSet(b)

    if computer[a] > computer[b] :
        computer[computer[a]] = computer[b]
    else :
        computer[computer[b]] = computer[a]

def findSet(a) :
    if computer[a] == a :
        return a
    computer[a] = findSet(computer[a])
    return computer[a]

makeSet()

for i in range(M) :
    x, y = map(int, input().split())
    union(x, y)
result = 0

for i in range(2,N+1):
    if computer[1] == findSet(i) :
        result += 1

print(result)