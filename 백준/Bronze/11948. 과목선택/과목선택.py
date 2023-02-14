import sys

scoreScience = []
scoreLiberal = []

for i in range(6) :
    if i < 4 :
        scoreScience.append(int(sys.stdin.readline()))
    else :
        scoreLiberal.append(int(sys.stdin.readline()))

scoreScience.sort(reverse=True)
scoreLiberal.sort(reverse=True)

scoreScience.pop()
scoreLiberal.pop()

result = sum(scoreScience) + sum(scoreLiberal)

print(result)