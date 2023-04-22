import sys
input = sys.stdin.readline

char1 = input()
char2 = input()

lenChar1 = len(char1)
lenChar2 = len(char2)

result = 0

charList = [[0 for _ in range(lenChar2)] for _ in range(lenChar1)]

for i in range(1, lenChar1) :
    for j in range(1, lenChar2) :
        if char1[i-1] == char2[j-1] :
            charList[i][j] = charList[i-1][j-1] + 1

            if result < charList[i][j]:
                result = charList[i][j]

print(result)