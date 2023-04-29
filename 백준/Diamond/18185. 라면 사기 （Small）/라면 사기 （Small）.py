import sys
input = sys.stdin.readline

N = int(input())
laman = list(map(int, input().split()))
result = 0

for i in range(N) :
    # 이 집에서 살 라멘이 없으면 pass
    if laman[i] == 0 :
        continue

    # 남은 공장이 2개 이상일 때
    if i + 1 < N:
        # 남은 공장이 3개 이상일 때
        if i + 2 < N :
            if laman[i+1] > laman[i+2] :
                comp = min(laman[i], laman[i+1] - laman[i+2])

                laman[i] -= comp
                laman[i + 1] -= comp

                result += comp * 5

            comp = min(laman[i], laman[i+1], laman[i+2])

            laman[i] -= comp
            laman[i + 1] -= comp
            laman[i + 2] -= comp

            result += comp * 7

        comp = min(laman[i], laman[i + 1])

        laman[i] -= comp
        laman[i + 1] -= comp
        result += comp * 5

    # 남은 라멘 단품 구매하기
    result += laman[i] * 3

print(result)