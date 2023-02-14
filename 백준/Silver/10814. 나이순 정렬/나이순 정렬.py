import sys

N = int(sys.stdin.readline())

members = []

for i in range(N):
    person = list(input().split())
    person[0] = int(person[0])
    members.append(person)
members.sort(key= lambda x : x[0])

for i in range(N) :
    print(members[i][0], members[i][1])