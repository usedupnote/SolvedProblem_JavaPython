N, M = map(int, input().split())

minimum = 1000

share = N // 6
rest = N % 6

set = []
single = []

for i in range(M) :
    a, b = map(int, input().split())
    set.append(a)
    single.append(b)

print(min((share + 1) * min(set), share * min(set) + rest * min(single), N * min(single)))