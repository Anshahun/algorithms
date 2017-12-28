/*
 ============================================================================
 Name        : backpack.c
 Author      : ljy
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 5

struct item{
	int weight;
	int value;
};
struct item items[SIZE];
int sw[SIZE];
//int ar[12];
int arr[] = {1,2,3,4,5};
int maxweight = 10;
int maxvalue = 0;
void printArr(int arr[],int n);

int contains(int* src,int dest){
	return *(src+dest);
}

int process(int* escapeIndex){
	int num = 0;
	int currentValue = 0;
	for(int i=0;i<SIZE;i++){
		if(contains(escapeIndex,i)&&num+items[i].weight<=maxweight){
			num+=items[i].weight;
			currentValue+=items[i].value;
			printf("%d",items[i].weight);
		}
	}
	return currentValue;
}

void printArr(int* arr,int n){
	for(int i=0;i<n;i++){
		printf("%d,",*(arr+i));
	}
	printf("\n");
}

void init(int** arr,int n){
	for(int i=0;i<n;i++){
		**arr = -1;
	}
}

void enumration(){
	int i=0;
	while(1){
		i = 0;
		sw[i]++;
		while(sw[i]>1){
			sw[i] = 0;
			i++;
			if(i<SIZE)
				sw[i]++;
			else
				return;
		}
		int value = process(sw);
		if(value>maxvalue)
			maxvalue = value;
		printf("========%d=\n",value);
	}
}

void arrange(){
	int i=0;//选择位置
	int j=0;//原始数组位置
	int num = 0;
	while(j<SIZE){
		i=0;
		j++;
		num = 0;
		int ar[12];
		//init(ar,12);
		while(num<maxweight){
			ar[i] = arr[j];
			num+=arr[j];
			i++;
		}
		printArr(ar,12);
	}
}

int main(void) {
	struct item i1 = {1,5};
	struct item i2 = {2,4};
	struct item i3 = {3,3};
	struct item i4 = {4,2};
	struct item i5 = {5,1};
	//struct item i6 = {4,3};
	items[0] = i1;
	items[1] = i2;
	items[2] = i3;
	items[3] = i4;
	items[4] = i5;
	//items[5] = i6;
	enumration();
	//arrange();
	printf("%d",maxvalue);
	return EXIT_SUCCESS;
}
