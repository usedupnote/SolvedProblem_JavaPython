import sys
input = sys.stdin.readline

result = 0

for i in range(5) :
    start, end = input().split()
    
    start_list = list(map(int, start.split(":")))
    end_list = list(map(int, end.split(":")))

    result += (end_list[0] - start_list[0]) * 60
    result += (end_list[1] - start_list[1])

print(result)