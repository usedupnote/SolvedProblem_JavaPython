import sys
input = sys.stdin.readline

univ = ["Soongsil", "Korea", "Hanyang"]

num = list(map(int, input().split()))

if sum(num) < 100 :
    check = min(num)
    for i in range(3) :
        if check == num[i] :
            print(univ[i])
            break
else :
    print("OK")