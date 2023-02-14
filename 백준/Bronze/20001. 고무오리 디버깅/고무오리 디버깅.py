import sys
input = sys.stdin.readline

check = 0

duck = input().strip()

while True:
    duck = input().strip()

    if duck == "고무오리 디버깅 끝":
        if check == 0 :
            print("고무오리야 사랑해")
            break
        else :
            print("힝구")
            break
    elif duck == "고무오리":
        if check == 0 :
            check += 2
        else:
            check -= 1
    else :
        check += 1