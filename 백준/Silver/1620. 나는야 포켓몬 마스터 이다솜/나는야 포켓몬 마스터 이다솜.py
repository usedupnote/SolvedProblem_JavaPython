import sys
input = sys.stdin.readline

N, M = map(int, input().split())

doc = {}

for i in range(1, N+1) :
    ch = str(i)
    doc[ch] = input().strip()
    doc[doc[ch]] = ch

for i in range(M) :
    print(doc.get(input().strip()))