import sys
while True :
    string = list(sys.stdin.readline())

    vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']

    result = 0

    if string[0] == "#" :
        break

    for i in string :
        if i in vowels :
            result += 1
    print(result)