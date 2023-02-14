import sys

T = int(sys.stdin.readline())

for i in range(T) :
    N = int(sys.stdin.readline())

    schools = []

    for j in range(N) :
        get = list(sys.stdin.readline().split())
        get[1] = int(get[1])
        schools.append(get)

    schools.sort(reverse=True, key=lambda x : x[1])

    print(schools[0][0])