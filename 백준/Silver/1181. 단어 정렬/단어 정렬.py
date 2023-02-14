N = int(input())

wordCollecter = []

for i in range(N) :
    wordCollecter.append(input())

wordCollecter = list(set(wordCollecter))

wordCollecter.sort()
wordCollecter.sort(key=len)

for i in range(len(wordCollecter)) :
    print(wordCollecter[i])