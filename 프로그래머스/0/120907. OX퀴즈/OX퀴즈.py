def solution(quiz):
    answer = []
    
    for item in quiz:
        quizItems = item.split(" = ")
        
        calItem = quizItems[0].split(" ")
        result = int(calItem[0])
        if calItem[1] == "+":
            result += int(calItem[2])
        else:
            result -= int(calItem[2])
            
        if result == int(quizItems[1]):
            answer.append("O")
        else :
            answer.append("X")
            
    return answer