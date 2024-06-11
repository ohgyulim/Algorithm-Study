import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int y;
	int x;

	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class B16234 {
	static int N;
	static int minGap;
	static int maxGap;
	static int[][] matrix;
	static int[][] modified;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int result = 0;

		N = sc.nextInt();
		minGap = sc.nextInt();
		maxGap = sc.nextInt();

		matrix = new int[N + 1][N + 1];
		modified = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = sc.nextInt();
				modified[i][j] = matrix[i][j];
			}
		}

		while (execute()) {
			result += 1;
		}

		System.out.println(result);
	}

	public static boolean execute() {
		boolean[][] checkMatrix = new boolean[N + 1][N + 1];
		boolean executeBFS = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (checkMatrix[i][j]) continue;
				if (bfs(i, j, checkMatrix)) executeBFS = true;
			}
		}
		if (executeBFS) {
			applyModified();
			return true;
		}
		return false;
	}

	public static void applyModified() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrix[i][j] != modified[i][j])
					matrix[i][j] = modified[i][j];
			}
		}
	}

	public static boolean bfs(int ey, int ex, boolean[][] checkMatrix) {
		int sum = 0;
		int count = 0;
		Queue<Pos> queue = new LinkedList<>();
		Queue<Pos> modifiedQueue = new LinkedList<>();
		queue.add(new Pos(ey, ex));
		modifiedQueue.add(new Pos(ey, ex));
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int y = pos.y + dy[i];
				int x = pos.x + dx[i];
				if (checkPos(y, x) && checkGap(pos.y, pos.x, y, x) && !checkMatrix[y][x]) {
					checkMatrix[y][x] = true;
					sum += matrix[y][x];
					count += 1;
					queue.add(new Pos(y, x));
					modifiedQueue.add(new Pos(y, x));
				}
			}
		}

		if (count == 0)
			return false;

		while (!modifiedQueue.isEmpty()) {
			Pos pos = modifiedQueue.poll();
			modified[pos.y][pos.x] = sum / count;
		}

		return true;
	}

	public static boolean checkPos(int y, int x) {
		return y >= 1 && y <= N && x >= 1 && x <= N;
	}

	public static boolean checkGap(int prevY, int prevX, int y, int x) {
		return Math.abs(matrix[prevY][prevX] - matrix[y][x]) >= minGap
			&& Math.abs(matrix[prevY][prevX] - matrix[y][x]) <= maxGap;
	}
}
