import sys
input = sys.stdin.readline

mushroom = []
result = 0

for i in range(10) :
    mushroom.append(int(input()))

    result += mushroom[i]

    if result >= 100 :
        if 100 - (result - mushroom[i]) < result - 100 :
            print(result - mushroom[i])
        else :
            print(result)
        break
    if i == 9 :
        print(result)