tri = input().split()

while tri[0] != "0" or tri[1] != "0" or tri[2] != "0" :

    for i in range(3) :
        tri[i] = int(tri[i])

    if ((max(tri) ** 2) * 2) == ((tri[0] ** 2) + (tri[1] ** 2) + (tri[2] ** 2)) :
       print("right")
    else :
       print("wrong")

    tri = input().split()