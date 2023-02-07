import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T) :
    x1, y1, x2, y2 = map(int, input().split())

    N = int(input())

    result = 0

    for i in range(N) :
        cx, cy, r = map(int, input().split())

        check = 0

        if (r * r) < ((cx - x1) * (cx - x1)) + ((cy - y1) * (cy - y1)) :
            check += 1
        if (r * r) < ((cx - x2) * (cx - x2)) + ((cy - y2) * (cy - y2)) :
            check += 1

        result += (check % 2)
    print(result)