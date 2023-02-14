burger = []
drink = []
for i in range(3):
    burger.append(int(input()))

for i in range(2):
    drink.append(int(input()))

burger.sort()
drink.sort()

print(burger[0] + drink[0] - 50)