import sys

while True :
    triangle = list(map(int, sys.stdin.readline().split()))

    if sum(triangle) == 0 : break

    triangle.sort()

    if triangle[2] < triangle[1] + triangle[0] :
        if triangle[0] == triangle[2] : print("Equilateral")
        elif triangle[0] == triangle[1] or triangle[1] == triangle[2]: print("Isosceles")
        else : print("Scalene")
    else :
        print("Invalid")