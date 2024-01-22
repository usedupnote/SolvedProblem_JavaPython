import sys
input = sys.stdin.readline

N = int(input())
num = input()

result = 0
i = N - 1

while True :
    if i < 0 :
        break
    if i-2 >= 0 :
        if int(num[i-2]) == 0 :
            if int(num[i-1]) == 0 :
                i -= 1
            else :
                i -= 2
        else :
            if int(num[i - 2: i+1]) > 641:
                if int(num[i-1]) == 0 :
                    i -= 1
                else :
                    i -= 2
            else:
                i -= 3
    else :
        i -= 3

    result += 1

print(result)
