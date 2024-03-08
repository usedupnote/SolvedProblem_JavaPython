def solution(arr1, arr2):
    if len(arr1) > len(arr2) :
        return 1
    elif len(arr1) < len(arr2) :
        return -1
    else :
        sumA = sum(arr1) - sum(arr2)
        if sumA > 0 :
            return 1
        elif sumA < 0:
            return -1
        else:
            return 0
