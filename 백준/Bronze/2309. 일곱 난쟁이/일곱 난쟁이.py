import sys

person = []

for i in range(9) :
    person.append(int(sys.stdin.readline().strip()))

compare = sum(person) - 100

person.sort()

for i in range(8) :
    for j in range(i, 9) :
        check = person[i] + person[j]
        if compare == check :
            person.pop(j)
            person.pop(i)
            break
        elif compare < check :
            break

    if len(person) == 7 :
        break

for i in range(7) :
    person[i] = str(person[i])

print("\n".join(person))