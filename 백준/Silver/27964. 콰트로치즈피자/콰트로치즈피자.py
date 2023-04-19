import sys
input = sys.stdin.readline

N = int(input())
topping = list(input().split())

cheese = {}

for i in range(len(topping)) :
    if topping[i][len(topping[i]) - 6:] == "Cheese":
        if cheese.get(topping[i]) == None :
            cheese[topping[i]] = 1

if len(cheese) >= 4 :
    print("yummy")
else :
    print("sad")