package com.makers.showmethemoney.model.game;

import java.util.Random;

public class GameData {
	// singleton pattern
	public static GameData data = null;
	
	private int arr[][] = new int[8][8]; // map에 랜덤으로 초기화 할 배열
	private int score[] = new int[9]; // 각 icon별 제거한 개수 담을 배열
	private int totalScore = 0;
	private int time = 600;

	public boolean gameFinish = false; // 게임 종료 여부 판단

	/********** 생성자 **********/
	public GameData() {
		setInitArray();
		setRandomArray();
		setInitMap(arr);
	}
	
	/********** array 초기화 메소드 **********/
	public void setInitArray() {
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				arr[i][j] = 0;
	}
	
	/********** array 랜덤값 초기화 메소드 **********/
	public void setRandomArray() {
		Random random = new Random(); // 랜덤 객체 생성
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1; // 1~6까지의 랜덤 값을 대입
				
				int a = i, b = j;
				// 행이나 열이 3 이상일 때 2번째 전 행(열)과 1번째 전 행(열), 현재 행(열)이 같으면 j를 감소시켜
				// 다시 random값을 받음
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b])
						|| (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b]))
					j--;
			}
		}
	}

	/********** GameData 스스로의 정보를 담는 객체를 생성하는 메소드 **********/
	public static GameData getInstance() {
		if (data == null) {
			data = new GameData();
		}
		return data;
	}

	/**------------------ about Map ------------------**/
	int map[][] = { // Game map의 각 value를 담을 배열
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1 } };

	/********** map을 arr의 value값으로 초기화 하는 메소드 **********/
	public void setInitMap(int arr[][]) {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				this.map[i][j] = arr[i][j];
			}
		}
	}

	/********** (x,y)위치에 들어있는 value값을 반환하는 메소드 **********/
	public int getMap(int x, int y) {
		return map[x][y];
	}

	/********** (x,y)위치의 값을 value로 바꾸는 메소드 **********/
	public void setMap(int x, int y, int value) {
		this.map[x][y] = value;
	}
	
	/**------------------ about score ------------------**/
	/********** score를 초기화 하는 메소드 **********/
	public void setInitScore() {
		for (int i = 0; i < 7; i++)
			score[i] = 0;
	}
	
	/********** score를 세팅하는 메소드 **********/
	public void setScore(int value, int cnt) {
		score[value] += cnt;
	}

	/********** score를 반환하는 메소드 **********/
	public int[] getScore() {
		return score;
	}
	
	/********** totalscore를 초기화 하는 메소드 **********/
	public void setInitTotal(){
	      totalScore = 0;
	}

	/********** score를 더해주는 메소드  **********/
	public void sumTotal() {
		double j = 2.0;
		int temp = 0;
		for (int i = 1; i < 7; i++, j-=0.2) {
			temp += score[i] * j * 100;
		}
		temp += score[0] * 500;
		totalScore = temp;
	}
	
	/********** totalScore를 반환하는 메소드 **********/
	public int getTotal() {
		return totalScore;
	}
	
	/**------------------ about time ------------------**/
	/********** time을 반환하는 메소드 **********/
	public void initTime() {
		time = 600;
	}
	
	/********** time을 반환하는 메소드 **********/
	public int getTime() {
		return time;
	}

	/********** time을 감소시키는 메소드 **********/
	public void setTime(int time) {
		this.time -= time;
	}
	
	/********** 게임이 종료되었음을 저장하는 메소드 **********/
	public void setGameFinish() {
		gameFinish = true;
	}
	
	/********** GameFinish를 초기상태로 되돌려주는 메소드 **********/
	public void setGameStart() {
		gameFinish = false;
	}
	
	/********** 게임 종료 여부를 반환하는 메소드 **********/
	public boolean getGameFinish() {
		return gameFinish;
	}
}