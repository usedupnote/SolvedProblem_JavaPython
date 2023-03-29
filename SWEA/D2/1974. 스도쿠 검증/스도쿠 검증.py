T = int(input())

def checkSdocu(M) :

    for i in range(9) :
        row = [0] * 10
        column = [0] * 10

        for j in range(9) :
            if row[M[i][j]] == 1 :
                return 0
            else : row[M[i][j]] += 1
            if column[M[j][i]] == 1 :
                return 0
            else : column[M[j][i]] += 1

    for i in range(3) :
        box = [0] * 10
        for j in range(3) :
            for k in range(3) :
                if box[M[(i*3) + j][(i*3) + k]] == 1:
                    return 0
                else : box[M[(i*3) + j][(i*3) + k]] += 1
    return 1

for test_case in range(1, T+1):
    sdocu = [list(map(int, input().split())) for _ in range(9)]

    print("#{} {}".format(test_case, checkSdocu(sdocu)))