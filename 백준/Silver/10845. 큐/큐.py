import sys
input = sys.stdin.readline

N = int(input())
li = []
fuc1 = lambda x:1 if x==0 else 0
fuc2 = lambda x:-1 if x==0 else li.pop(0)
fuc3 = lambda x:-1 if x==0 else li[0]
fuc4 = lambda x:-1 if x==0 else li[len(li)-1]

for i in range(N) :
    order = input()
    if order[1] == 'u' :
        li.append(order.split()[1])
    elif order[1] == 'o' :
        print(fuc2(len(li)))
    elif order[1] == 'i' :
        print(len(li))
    elif order[1] == 'm' :
        print(fuc1(len(li)))
    elif order[1] == 'r' :
        print(fuc3(len(li)))
    else :
        print(fuc4(len(li)))