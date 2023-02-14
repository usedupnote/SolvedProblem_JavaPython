T = int(input())

for i in range(T) :
    check = 0
    result = 0

    quizee = list(input())

    for j in range(len(quizee)) :
        if quizee[j] == "O":
            check += 1
            result += check
        if quizee[j] == "X":
            check = 0
    print(result)