#include <stdio.h>

int set_ary[5][6] = {{1, 2, 3, 4, 5, 6},
                     {10, 15, 25, 35, 40, 42},
                     {1, 9, 11, 22, 23, 25},
                     {9, 28, 31, 34, 35, 36},
                     {1, 9, 23, 28, 33, 35}};

int check_ary[5][8];

int user_ary[6], bonus = 0;

void check() {
  for (int i = 0; i < 5; ++i) {
    int temp = 0;

    for (int j = 0; j < 6; ++j) {
      for (int k = 0; k < 6; ++k) {
        if (set_ary[i][j] == user_ary[k]) {
          check_ary[i][j] = user_ary[k];
          ++temp;
          break;
        } else {
          check_ary[i][j] = -1;
        }
      }
    }

    check_ary[i][6] = temp;

    if (check_ary[i][6] == 5) {
      for (int j = 0; j < 6; ++j) {
        if (set_ary[i][j] == bonus) {
          check_ary[i][j] = bonus;
          check_ary[i][7] = 1;
        }
      }
    }
  }
}

void printAns(int idx, int num) {
  if (num >= 5) {
    if (num == 6)
      printf("<1등>");
    else if (num == 5 && check_ary[idx][7] == 1)
      printf("<2등>");
    else if (num == 5 && check_ary[idx][7] == 0)
      printf("<3등>");
  } else if (num < 5) {
    if (num == 4)
      printf("<4등>");
    else if (num == 3)
      printf("<5등>");
    else
      printf("<꽝>");
  }
}

int main(void) {
  printf("금주의 로또 번호를 입력하세요 -> ");

  for (int i = 0; i < 6; ++i) {
    scanf("%d", &user_ary[i]);
  }

  printf("보너스 번호를 입력하세요 -> ");
  scanf("%d", &bonus);

  printf("\n");
  printf("홍길동님의 로또 당첨 결과는 다음과 같습니다.\n");
  printf("\n");

  for (int i = 0; i < 5; ++i) {
    printf("%d세트 번호", i + 1);
    printf("<");

    for (int j = 0; j < 6; ++j) {
      printf("%d ", set_ary[i][j]);
    }

    printf(">");
    printf(" -> ");

    check();

    for (int j = 0; j < 6; ++j) {
      if (check_ary[i][j] == -1)
        printf("X ");
      else
        printf("%d ", check_ary[i][j]);
    }

    printAns(i, check_ary[i][6]);

    printf("\n");
  }

  return 0;
}
