word = input()
word = list(word.upper())
length = len(word)

checker = []

for i in range(27) :
    checker.append(0)

while length > 0 :
    checker[ord(word[length - 1]) - ord("A") + 1] += 1
    length -= 1

maximum = max(checker)

for i in range(1, 27) :
    if maximum == checker[i] :
        checker[i] = 1
    else :
        checker[i] = 0

if sum(checker) == 1 :
    for i in range(1, 27) :
        if checker[i] == 1 :
            print(chr(ord("A") + i - 1))
            break
else :
    print("?")