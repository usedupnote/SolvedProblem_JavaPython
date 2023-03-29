for i in range(10):
    T = int(input())

    columnResult = [0] * 100

    crossLeftupToRightdown = 0
    crossLeftdownToRightup = 0

    result = 0

    for j in range(100):
        num = list(map(int, input().split()))

        for j in range(100):
            columnResult[j] += num[j]

        crossLeftupToRightdown += num[j]
        crossLeftdownToRightup += num[99 - j]

        result = max(result, sum(num))

    result = max(result, crossLeftdownToRightup, crossLeftupToRightdown, max(columnResult))

    print("#{} {}".format(T, result))