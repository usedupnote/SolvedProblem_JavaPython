import sys
input = sys.stdin.readline

comp = {'D' : 0 , 'P' : 0}

N = int(input())

for i in range(N) :
    win = input()
    comp[win[0]] += 1

    if abs(comp['D'] - comp['P']) > 1 :
        break

print(comp['D'], ':', comp['P'], sep="")