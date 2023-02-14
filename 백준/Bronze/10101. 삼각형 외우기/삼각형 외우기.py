import sys

angle = []

for i in range(3) :
    angle.append(int(sys.stdin.readline()))

if sum(angle) != 180 :
    print("Error")
else :
    if angle.count(60) == 3 :
        print("Equilateral")
    elif angle[0] == angle[1] or angle[1] == angle[2] or angle[0] == angle[2] :
        print("Isosceles")
    else :
        print("Scalene")