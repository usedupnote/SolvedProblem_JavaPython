def solution(s):
    numList = []

    for i in s.split(" "):
        if i == "Z":
            numList.pop()
        else :
            numList.append(int(i))

    return sum(numList)