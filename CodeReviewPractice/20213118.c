#include <stdio.h>
int main() {
	int right=0;
	int bonusright = 0;
	int reallotto[7];
	int check = 0;
	int honglotto[5][6] = {
	{1,2,3,4,5,6},
	{10,15,25,35,40,42},
	{1,9,11,22,23,25},
	{9,28,31,34,35,36},
	{1,9,23,28,33,35}};
	printf("금주의 로또 번호를 입력하세요:");

	for (int i = 0; i < 6; i++) {
		scanf("%d", &reallotto[i]);
	}
	printf("\n보너스 번호를 입력하세요:");
	scanf("%d", &reallotto[6]);
	/*for (int i = 0; i < 6; i++) { 로또 입력 번호 확인용
		printf("%d\n", reallotto[i]);
	}*/
	printf("\n홍길동님의 로또 당첨 결과입니다.\n\n");
	for (int i = 0; i < 5; i++) {                         //세트 번호 증가
		for (int j = 0; j < 6; j++)						  //세트 내에서의 홍길동 번호 증가
		{
			for (int k = 0; k < 6; k++){					  //세트 내에서의 홍길동 번호에게 각각의 로또넘버와 맞는지 체크해줌
				if (honglotto[i][j] == reallotto[k])
				{
					right += 1;
				}
			}
			if (honglotto[i][j] == reallotto[6])
				{
				bonusright += 1;
				}
			
		}
		printf("%d세트 번호<",i+1);
		for (int j = 0; j < 6; j++) {
			printf("%d ", honglotto[i][j]);
		}
		printf("> -> ");
		for (int j = 0; j < 6; j++)						  //세트 내에서의 홍길동 번호 증가
		{
			for (int k = 0; k < 6; k++) {					  //세트 내에서의 홍길동 번호에게 각각의 로또넘버와 맞는지 체크해줌
				if (honglotto[i][j] == reallotto[k])
				{
					check += 1;
				}
				
			}
			if (check == 1) {
				printf("%d ", honglotto[i][j]);
			}
			else {
				if (bonusright == 1 && right == 5)
					printf("%d ", honglotto[i][j]);
				else
					printf("x ");
			}
			check = 0;
		}
		if (right == 6) {
			printf("1등\n");
		}
		else if (right + bonusright == 6) {
			printf("2등\n");
		}
		else if (right == 5&& bonusright==0) {
			printf("3등\n");
		}
		else if (right == 4) {
			printf("4등\n");
		}
		else if (right == 3) {
			printf("5등\n");
		}
		else {
			printf("꽝\n");
		}
		//printf("right:%d, bonusright:%d\n", right, bonusright); right, bonusright 디버깅용
		
		right = 0;
		bonusright = 0;
	}
	return 0;
}