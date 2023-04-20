from queue import PriorityQueue
import sys
input = sys.stdin.readline

N = int(input())
Town = PriorityQueue()
sumPer = 0
person = {}

for i in range(N) :
    pos, per = list(map(int, input().split()))
    Town.put(pos)
    person[pos] = per
    sumPer += per

sumPer /= 2

for i in range(N) :
    current = Town.get()
    sumPer -= person[current]

    if sumPer <= 0 :
        print(current)
        break