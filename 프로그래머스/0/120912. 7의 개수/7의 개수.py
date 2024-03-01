def solution(array):
    return sum([str(i).count("7") for i in array])