import sys

N = int(input())

bag = {5:N//5 + 1, 3:(N%5)//3}

while True :
    bag[5] -= 1
    bag[3] = (N - (5 * bag[5])) // 3

    if bag[5] < 0 :
        print(-1)
        break

    if N == (5 * bag[5]) + (3 * bag[3]) :
        print(bag[5] + bag[3])
        break