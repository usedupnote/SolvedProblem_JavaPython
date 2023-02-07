for test_case in range(1, 11) :
    section = int(input())
    map = [list(input()) for _ in range(16)]
    savepoint = [[1, 1]]
    nowpoint = [1, 1]

    map[1][1] = "1"

    result = 0

    while True:
        x = nowpoint[0]
        y = nowpoint[1]

        if int(map[x+1][y]) + int(map[x-1][y]) + int(map[x][y+1]) + int(map[x][y-1]) < 3 :
            savepoint.append([x, y])

        if map[x][y] == "3" :
            result = "1"
            break

        map[x][y] = "1"

        if map[x+1][y] != "1" :
            nowpoint[0] += 1

        elif map[x][y-1] != "1" :
            nowpoint[1] -= 1

        elif map[x][y+1] != "1" :
            nowpoint[1] += 1

        elif map[x-1][y] != "1" :
            nowpoint[0] -= 1

        else :
            if len(savepoint) == 0 :
                break
            else :
                nowpoint = savepoint.pop()

    print("#{} {}".format(section, result))