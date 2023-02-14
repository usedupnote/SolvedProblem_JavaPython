V = int(input())

count = list(input())

check = [0, 0]

for i in range(V) :
    if(count[i] == "A") :
        check[0] += 1
    else :
        check[1] += 1
if check[0] > check[1] :
    print("A")
elif check[0] < check[1]:
    print("B")
else :
    print("Tie")