import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(1, T + 1) :
    num = int(input())

    cnt = 0

    while num != 0 :
        if num % 2 == 1 :
            print(cnt, end = " ")
        num //= 2
        cnt += 1
    print()