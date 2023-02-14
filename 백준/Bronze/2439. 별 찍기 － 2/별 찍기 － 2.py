star = int(input())

for i in range(1,star+1):
    for j in range(star, 0, -1):
        if j > i:
            print(" ", end="")
        else:
            print("*", end="")
    print("")