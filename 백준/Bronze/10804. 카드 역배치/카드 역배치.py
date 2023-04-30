import sys
input = sys.stdin.readline

card = [i for i in range(21)]

for i in range(10) :
    start, end = map(int, input().split())

    while start < end :
        card[start] += card[end]
        card[end] = card[start] - card[end]
        card[start] -= card[end]
        start += 1
        end   -= 1

print(str(card).replace("[0, ", "").replace(",", "").replace("]", ""))