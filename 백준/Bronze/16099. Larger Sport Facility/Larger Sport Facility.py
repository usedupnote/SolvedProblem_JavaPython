import sys
input = sys.stdin.readline

N = int(input())

for i in range(N) :
    num = list(map(int, input().split()))

    if num[0] * num[1] > num[2] * num[3] :
        print("TelecomParisTech")
    elif num[0] * num[1] == num[2] * num[3] :
        print("Tie")
    else :
        print("Eurecom")