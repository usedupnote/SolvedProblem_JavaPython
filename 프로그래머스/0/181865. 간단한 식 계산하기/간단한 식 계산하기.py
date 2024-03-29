def solution(binomial):
    answer = 0
    sepB = binomial.split()
    if sepB[1] == "+":
        answer = int(sepB[0]) + int(sepB[2])
    elif sepB[1] == "-":
        answer = int(sepB[0]) - int(sepB[2])
    elif sepB[1] == "*":
        answer = int(sepB[0]) * int(sepB[2])
    return answer