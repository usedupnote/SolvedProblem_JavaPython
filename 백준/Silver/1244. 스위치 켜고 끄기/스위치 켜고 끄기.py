import sys
input = sys.stdin.readline

N = int(input())
v = list(map(int, input().split()))
M = int(input())

for i in range(M) :
    gender, num = map(int, input().split())

    if gender == 1 :  # male
        cnt = num
        while N >= cnt:
            v[cnt-1] = (v[cnt-1] + 1) % 2
            cnt += num

    else :            # female
        v[num-1] = (v[num-1] + 1) % 2
        start = num - 2
        end = num

        while 0<=start and end < N :
            if v[start] == v[end] :
                v[start] = (v[start] + 1) % 2
                v[end] = v[start]
                start -= 1
                end += 1
            else :
                break

for i in range(1, N + 1) :
    print(v[i - 1], end="")

    if i % 20 == 0 :
        print()
    else :
        print(" ", end="")