T = int(input())

for i in range(T) :
    password = input()
    pasLen = len(password)
    if pasLen < 10 and pasLen > 5 :
        print("yes")
    else :
        print("no")