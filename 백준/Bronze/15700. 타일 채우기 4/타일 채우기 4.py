def main():
    import sys
    input = sys.stdin.readline

    A, B = map(int, input().split())

    print((A*B) // 2)

if __name__ == "__main__":
    main()