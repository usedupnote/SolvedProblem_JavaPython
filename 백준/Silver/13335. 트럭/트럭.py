import sys
input = sys.stdin.readline

# n 다리를 건너는 트럭의 수 (1 ≤ n ≤ 1,000), w 다리의 길이(1 ≤ w ≤ 100) L 다리의 최대하중(10 ≤ L ≤ 1,000)
n, w, L = map(int, input().split())

# an (1 ≤ ai ≤ 10) [ai = i번째 트럭의 무게]
tW = list(map(int, input().split()))

curW = [0 for _ in range(n * w + 1)]

for t in range(len(curW)):

    if len(tW) == 0 :
        if curW[t] == 0 :
            print(t+1)
            break
        continue
    elif curW[t] + tW[0] > L :
        continue

    for i in range(w) :
        curW[t+i] += tW[0]

    tW.pop(0)