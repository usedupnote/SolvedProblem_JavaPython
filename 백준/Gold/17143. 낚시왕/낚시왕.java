import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int x, y;
        int speed;
        int direction;
        int size;

        public Shark(int x, int y, int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    static Shark[][] water, newWater;
    static int R, C, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        water = new Shark[R + 1][C + 1];
        for(int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x         = Integer.parseInt(stringTokenizer.nextToken());
            int y         = Integer.parseInt(stringTokenizer.nextToken());
            int speed     = Integer.parseInt(stringTokenizer.nextToken());
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            int size      = Integer.parseInt(stringTokenizer.nextToken());
            water[x][y]   = new Shark(x, y, speed, direction, size);
        }

        int result = 0;
        for(int col = 1; col <= C && M > 0; col++) {
            // 해당 열에서 땅과 제일 가까운 상어를 잡는다
            for(int r = 1; r <= R; r++) {
                if(water[r][col] != null) {
                    result += water[r][col].size;
                    water[r][col] = null;
                    M--;
                    break;
                }
            }

            // 상어가 이동한다
            newWater = new Shark[R + 1][C + 1];
            for(int r = 1; r <= R; r++) {
                for(int c = 1; c <= C; c++) {
                    if(water[r][c] == null) continue;
                    if(water[r][c].direction <= 2) {
                        moveAlongRow(water[r][c]);
                    } else {
                        moveAlongCol(water[r][c]);
                    }
                }
            }
            water = newWater;
        }
        System.out.println(result);
    }

    private static void moveAlongCol(Shark shark) {
        int dy = shark.direction == 4 ? -1 : 1;
        int nextY;

        if(shark.y + shark.speed * dy >= 1 && shark.y + shark.speed * dy <= C) {
            nextY = shark.y + shark.speed * dy;
        } else {
            int curr = shark.speed;
            curr -= (shark.direction == 4) ? shark.y - 1 : C - shark.y;
            int div = curr / (C - 1);
            int mod = curr % (C - 1);
            shark.direction = (div % 2 == 0) ? shark.direction + dy : shark.direction;

            if(shark.direction == 3) {
                nextY = 1 + mod; // R - mod
            } else {
                nextY = C - mod; // 1 + mod
            }
        }

        if(newWater[shark.x][nextY] != null && newWater[shark.x][nextY].size < shark.size) {
            M--;
            shark.y = nextY;
            newWater[shark.x][nextY] = shark;
        } else if(newWater[shark.x][nextY] == null) {
            shark.y = nextY;
            newWater[shark.x][nextY] = shark;
        }
    }

    private static void moveAlongRow(Shark shark) {
        int dx = shark.direction == 1 ? -1 : 1;
        int nextX;

        if(shark.x + shark.speed * dx >= 1 && shark.x + shark.speed * dx <= R) {
            nextX = shark.x + shark.speed * dx;
        } else {
            int curr = shark.speed;
            curr -= (shark.direction == 1) ? shark.x - 1 : R - shark.x;
            int div = curr / (R - 1);
            int mod = curr % (R - 1);
            shark.direction = (div % 2 == 0) ? shark.direction - dx : shark.direction;

            if(shark.direction == 1) {
                nextX = R - mod; // R - mod
            } else {
                nextX = 1 + mod; // 1 + mod
            }
        }

        if(newWater[nextX][shark.y] != null && newWater[nextX][shark.y].size < shark.size) {
            M--;
            shark.x = nextX;
            newWater[nextX][shark.y] = shark;
        } else if(newWater[nextX][shark.y] == null) {
            shark.x = nextX;
            newWater[nextX][shark.y] = shark;
        }
    }
}