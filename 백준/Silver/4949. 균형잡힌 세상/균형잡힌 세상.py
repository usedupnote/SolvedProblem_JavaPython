import sys

while True :
    bracket = []

    string = list(input())

    if string == ["."] :
        break

    result = "yes"

    for i in string :
        if i == "." :
            break
        if i == "(" or i == "[" :
            bracket.append(i)
        elif i == ")" :
            if len(bracket) == 0 :
                result = "no"
                break
            check = bracket.pop()
            if check != "(" :
                result = "no"
                break
        elif i == "]" :
            if len(bracket) == 0:
                result = "no"
                break
            check = bracket.pop()
            if check != "[" :
                result = "no"
                break
    if len(bracket) != 0 :
        result = "no"
    print(result)