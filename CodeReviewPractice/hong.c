#include<stdio.h>
void result(int n,int arr1[6],int arr2[n][6],int second);
int main(void){
	int today[6]={0};
	int bonus=0;
	printf("금주의 로또 번호를 입력하세요 -> ");
	for(int i=0;i<6;++i)
		scanf("%d",&today[i]);
	printf("보너스 번호를 입력하세요 -> ");
	scanf("%d",&bonus);
	printf("\n");
	printf("홍길동님의 로또 당첨 결과는 다음과 같습니다.\n");
	printf("\n");
	int hong[5][6]={
		{1,2,3,4,5,6},
		{10,15,25,35,40,42},
		{1,9,11,22,23,25},
		{9,28,31,34,35,36},
		{1,9,23,28,33,35}
	};
	printf("1세트 번호(1 2 3 4 5 6) -> ");
	result(0,today,hong,bonus);
	printf("2세트 번호(10 15 25 35 40 42) -> ");
	result(1,today,hong,bonus);
	printf("3세트 번호(1 9 11 22 23 25) -> ");
	result(2,today,hong,bonus);
	printf("4세트 번호(9 28 31 34 35 36) -> ");
	result(3,today,hong,bonus);
	printf("5세트 번호(1 9 23 28 33 35) -> ");
	result(4,today,hong,bonus);
	return 0;
}
void result(int n,int arr1[6],int arr2[n][6],int second){
	int last_result=0;
	int second_result=0;
	int y=0;
	int pri_result[6]={0};
	for(int k=0;k<6;++k){
		for(int i=0;i<6;++i){
			if(arr2[n][k]==arr1[i]){
				pri_result[k]=arr1[i];
				++last_result;
				break;
			}
			else if(arr2[n][k]==second){
				second_result=1;
				y=k;
			}
		}
	}
	if(last_result==5 && second_result==1)
		pri_result[y]=second;
	for(int l=0;l<6;++l){
		if(pri_result[l]==0)
			printf(" x");
		else
			printf(" %d",pri_result[l]);
	}
	if(last_result==6)
		printf("(1등)\n");
	else if(last_result==5 && second_result==1)
		printf("(2등)\n");
	else if(last_result==5 && second_result==0)
		printf("(3등)\n");
	else if(last_result==4)
		printf("(4등)\n");
	else if(last_result==3)
		printf("(5등)\n");
	else
		printf("(꽝)\n");
	return;
}
