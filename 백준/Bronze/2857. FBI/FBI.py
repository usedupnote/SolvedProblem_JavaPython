import sys
input = sys.stdin.readline

cnt = 0
for i in range(1, 6):
    S = input()
    if S.find("FBI") > -1 :
        print(i, end=" ")
        cnt+=1

if cnt == 0 :
    print("HE GOT AWAY!")