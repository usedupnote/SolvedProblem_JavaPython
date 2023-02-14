num = input()

while num != '0' :
    result = "yes"
    for i in range(int(len(num)/2)) :
        if num[i] != num[-i - 1] :
            result = "no"
            break
    print(result)
    num = input()