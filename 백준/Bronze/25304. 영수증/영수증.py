money = int(input())

T = int(input())

for i in range(1, T+1) :
    a, b = map(int, input().split())
    
    money -= a * b
    
    if money < 0 :
        break
    
if money != 0 :
    print("No")
else :
    print("Yes")