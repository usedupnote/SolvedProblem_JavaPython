N = int(input())

score = {"A+" : 4.3, "A0" : 4.0, "A-": 3.7, "B+": 3.3, "B0": 3.0, "B-": 2.7, "C+": 2.3, "C0": 2.0, "C-": 1.7, "D+": 1.3, "D0": 1.0, "D-": 0.7, "F" : 0}
A = 0
count = 0

for i in range(N) :
    s = input().split(" ")

    check = s[len(s) - 1]

    A += int(s[len(s) - 2]) * score[check] * 1000
    count += int(s[len(s) - 2])

result = A/count

if result % 10 >= 5 :
    result += 10
    result -= result % 10

print(f"{result/1000:.2f}")