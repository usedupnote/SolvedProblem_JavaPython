import sys
input = sys.stdin.readline

N, M = map(int, input().split())
bulbs = [input().strip() for _ in range(N)]
K = int(input())

pattern_count = {}

for bulb in bulbs:
    zero_count = bulb.count('0')

    # 꺼야 하는 스위치 수가 K 이내이고, 남은 횟수가 짝수일 때만 유효
    if zero_count <= K and (K - zero_count) % 2 == 0:
        if bulb not in pattern_count:
            pattern_count[bulb] = 1
        else:
            pattern_count[bulb] += 1

if pattern_count:
    print(max(pattern_count.values()))
else:
    print(0)
