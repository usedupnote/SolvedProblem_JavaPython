N = int(input())
compare = 1
count = 1

if N == 1 :
    print(1)
else :
    N -= 1
    while N > compare :
        N -= compare

        compare *= 2
        count += 1
    print(N * 2)