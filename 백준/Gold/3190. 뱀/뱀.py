import sys
input = sys.stdin.readline

DIR_X = [0, -1, 0, 1]
DIR_Y = [-1, 0, 1, 0]
DIR = {'L':3, 'D':1}

N = int(input())
K = int(input())

# apples = set([])
# for _ in range(K):
#     apples.add(list(map(int, input().split())))
m = [[0] * N for _ in range(N)]

for _ in range(K):
    x, y = map(int, input().split())
    m[x-1][y-1] = 1

L = int(input())

t = 0
snake = [[0, 0]]
snakeDir = 2
m[0][0] = -1

def moveSnake(time, target_time):
    isEnd = False
    for i in range(time, target_time):
        cur_snake = [snake[0][0] + DIR_X[snakeDir], snake[0][1] + DIR_Y[snakeDir]]
        if 0 > cur_snake[0] or cur_snake[0] >= N or 0 > cur_snake[1] or cur_snake[1] >= N or m[cur_snake[0]][cur_snake[1]] == -1:
            return -i
        snake.insert(0, cur_snake.copy())
        if m[cur_snake[0]][cur_snake[1]] != 1:
            end_snake = snake.pop()
            m[end_snake[0]][end_snake[1]] = 0
        m[cur_snake[0]][cur_snake[1]] = -1
    return target_time


for _ in range(L):
    targetT, d = input().split()

    t = moveSnake(t, int(targetT))

    if t < 0:
        break
    snakeDir = (snakeDir + DIR.get(d)) % 4

if t >= 0:
    t = moveSnake(t, 10_000)
print(-t+1)
