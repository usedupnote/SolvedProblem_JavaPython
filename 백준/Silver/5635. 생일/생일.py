import sys
T = int(sys.stdin.readline())    

birthday = []

for i in range(T) :
    person = list(sys.stdin.readline().split())
    
    for j in range(1,4) :
        person[j] = int(person[j])
    birthday.append([person[0], (person[3]* 10000) + (person[2] * 100) + person[1]])

birthday.sort(key= lambda x : x[1])

print(birthday[len(birthday)-1][0])
print(birthday[0][0])