import sys
input = sys.stdin.readline

DIR_X = [-1, 0, 1, 0] # 북 동 남 서
DIR_Y = [0, 1, 0, -1]

result = 0
N, M = map(int, input().split())
robot = list(map(int, input().split()))

room = [[] for _ in range(N)]

for i in range(N) :
    room[i] = list(map(int, input().split()))


# 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
def clean():
    if room[robot[0]][robot[1]] == 0:
        room[robot[0]][robot[1]] = 2
        return 1
    return 0

def move():
    if search(robot[0], robot[1]):
        dir = (robot[2] + 2) % 4
        dx = robot[0] + DIR_X[dir]
        dy = robot[1] + DIR_Y[dir]

        # 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        if room[dx][dy] == 1:
            return True

        # 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        robot[0] = dx
        robot[1] = dy

    else :
        # 3-1. 반시계 방향으로 90도 회전한다.
        robot[2] = (robot[2] + 3) % 4
        dx = robot[0] + DIR_X[robot[2]]
        dy = robot[1] + DIR_Y[robot[2]]
        # 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        if room[dx][dy]==0:
            robot[0] = dx
            robot[1] = dy
    return False

def search(x, y):
    for d in range(4):
        dx = x + DIR_X[d]
        dy = y + DIR_Y[d]

        if room[dx][dy] == 0:
            return False        # 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    return True                 # 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,

# 4. 1번으로 돌아간다.
while True:
    result += clean()

    if move():
        break

print(result)