num = input().split()

numDictionary = {0 : "mixed", 1 : "ascending", -1 : "descending"}

for i in range(len(num)) :
    num[i] = int(num[i])

sortNum = [1, 2, 3, 4, 5, 6, 7, 8]
reverseSortNum = [8, 7, 6, 5, 4, 3, 2, 1]

if num == sortNum :
    print(numDictionary[1])
elif num == reverseSortNum :
    print(numDictionary[-1])
else :
    print(numDictionary[0])