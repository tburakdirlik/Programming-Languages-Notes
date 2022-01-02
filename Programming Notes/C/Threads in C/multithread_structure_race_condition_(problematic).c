#include <stdio.h>
#include <pthread.h>
#define NUM_THREADS 4

void *threadFunc (void *parg){
	
	int myNum = *(int *)(parg);
	printf("Thread number %d\n", myNum);
	return 0;
}

int main (void){

	int i ;
	pthread_t tid[NUM_THREADS];
	for (i=0; i<NUM_THREADS; i++){
		pthread_create(&tid[i], NULL, threadFunc, &i);
					}

	for (i=0; i<NUM_THREADS; i++){
		pthread_join(tid[i], NULL);
					}

	return 0;

}
/*
EXAMPLE OUTPUT, some numbers are repeated cause of race condition, while a thread is read a value another one is modifying.
Thread number 2
Thread number 3
Thread number 3
Thread number 0
*/