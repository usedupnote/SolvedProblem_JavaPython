import sys

T = int(sys.stdin.readline())

deque = []

commandList = ["push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back"]

for i in range(T) :
    command = list(sys.stdin.readline().split())

    if command[0] == commandList[0] :
        deque.insert(0, command[1])

    elif command[0] == commandList[1] :
        deque.append(command[1])

    elif command[0] == commandList[2]:
        if len(deque) != 0: print(deque.pop(0))
        else: print(-1)

    elif command[0] == commandList[3]:
        if len(deque) != 0: print(deque.pop())
        else: print(-1)

    elif command[0] == commandList[4] :
        print(len(deque))

    elif command[0] == commandList[5] :
        if len(deque) != 0 : print(0)
        else : print(1)

    elif command[0] == commandList[6]:
        if len(deque) != 0 : print(deque[0])
        else : print(-1)

    else :
        if len(deque) != 0 : print(deque[len(deque) - 1])
        else : print(-1)