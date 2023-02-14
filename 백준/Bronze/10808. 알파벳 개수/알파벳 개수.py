import sys

text = list(sys.stdin.readline())

textList = []

for i in range(26) :
    textList.append(0)

for i in text[0:len(text)-1] :
    textList[ord(i) - ord("a")] += 1

print(*textList)