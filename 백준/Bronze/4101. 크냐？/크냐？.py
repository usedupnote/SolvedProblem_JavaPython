n1, n2 = input().split()
n1 = int(n1)
n2 = int(n2)

while (n1 != 0 and n2 != 0) :
    if n1 > n2 :
        print("Yes")
    else :
        print("No")
        
    n1, n2 = input().split()
    n1 = int(n1)
    n2 = int(n2)