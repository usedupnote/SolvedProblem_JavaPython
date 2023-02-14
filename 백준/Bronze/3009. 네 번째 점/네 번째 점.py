pointX = []
pointY = []

for i in range(3) :
    x, y = input().split()
    
    pointX.append(x)
    pointY.append(y)
    
if pointX[0] == pointX[1] :
    print(pointX[2], end = " ")
elif pointX[0] == pointX[2] :
    print(pointX[1], end = " ")
else : 
    print(pointX[0], end = " ")
    
if pointY[0] == pointY[1] :
    print(pointY[2])
elif pointY[0] == pointY[2] :
    print(pointY[1])
else :
    print(pointY[0]) 