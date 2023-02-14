inputGrade = input()

grade = 0.0

if inputGrade == "F" :
    # print(inputGrade, ": ", grade, sep = "")        #문제를 잘못 읽음
    print(grade)
else :
    gradeMain, gradeDetail = inputGrade
    grade = 4 - (ord(gradeMain) - ord("A"))
    if gradeDetail == "+" :
        grade += 0.3
    elif gradeDetail == "-" :
        grade -= 0.3
    # print(inputGrade, ": ", grade, sep = "")        #문제를 잘못 읽음
    print(format(grade, ".1f"))
"""
성적 정리
    A+: 4.3, A0: 4.0, A-: 3.7
    B+: 3.3, B0: 3.0, B-: 2.7
    C+: 2.3, C0: 2.0, C-: 1.7
    D+: 1.3, D0: 1.0, D-: 0.7
    F: 0.0
"""