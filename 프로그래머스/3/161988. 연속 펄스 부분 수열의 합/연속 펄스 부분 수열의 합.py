def solution(sequence):
    sign = [-1, 1]
    
    current = 0
    minimum = 0
    maximum = 0
    
    if len(sequence) == 1 :
        return (-sequence[0] if sequence[0]<0 else sequence[0])
    
    for i, num in enumerate(sequence):
        current += num * sign[i%2]
        if minimum > current :
            minimum = current
        if maximum < current :
            maximum = current
            
    return maximum - minimum