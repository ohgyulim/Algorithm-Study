import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B16235 {
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static int[][] foods;
	static int[][] remains;
	static ArrayList<Integer>[][] trees;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 양분의 배열 크기 N x N
		int M = sc.nextInt(); // 나무의 좌표, 나무의 나이
		int K = sc.nextInt(); // K년 후

		foods = new int[N + 1][N + 1];
		remains = new int[N + 1][N + 1];
		trees = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				foods[i][j] = sc.nextInt();
				remains[i][j] = 5;
				trees[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int age = sc.nextInt();
			trees[y][x].add(age);
		}

		for (int i = 0; i < K; i++) {
			springSummer();
			autumn();
			winter();
		}
		System.out.println(getResult());
	}

	public static void springSummer() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (trees[i][j].size() == 0)
					continue;
				Collections.sort(trees[i][j]);
				ArrayList<Integer> newTrees = new ArrayList<>();
				int deadNutrients = 0;

				for (int k = 0; k < trees[i][j].size(); k++) {
					int age = trees[i][j].get(k);
					if (remains[i][j] >= age) {
						remains[i][j] -= age;
						newTrees.add(age + 1);
					} else {
						deadNutrients += age / 2;
					}
				}
				trees[i][j] = newTrees;
				remains[i][j] += deadNutrients;
			}
		}
	}

	public static void autumn() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (trees[i][j].size() == 0)
					continue;
				for (int k = 0; k < trees[i][j].size(); k++) {
					if (trees[i][j].get(k) % 5 != 0)
						continue;
					for (int d = 0; d < 8; d++) {
						int nextY = i + dy[d];
						int nextX = j + dx[d];
						if (isInRange(nextY, nextX))
							trees[nextY][nextX].add(1);
					}
				}
			}
		}
	}

	public static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				remains[i][j] += foods[i][j];
			}
		}
	}

	public static boolean isInRange(int nextY, int nextX) {
		return (nextY >= 1 && nextY <= N) && (nextX >= 1 && nextX <= N);
	}

	public static int getResult() {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += trees[i][j].size();
			}
		}
		return result;
	}
}
