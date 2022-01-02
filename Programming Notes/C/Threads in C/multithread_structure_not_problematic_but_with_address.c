#include <stdio.h>
#include <pthread.h>
#define NUM_THREADS 4

void *threadFunc (void *parg){
	
	int myNum = *((int*)parg);
	printf("Thread number %d\n", myNum);
	return 0;
}

int main (void){

	int i;
	pthread_t tid[NUM_THREADS];
	for (i=0; i<NUM_THREADS; i++){
		tid[i]=i;
		pthread_create(&tid[i], NULL, threadFunc, &tid[i]);
					}

	for (i=0; i<NUM_THREADS; i++){
		pthread_join(tid[i], NULL);
					}

	return 0;

}
/*

EXAMPLE OUTPUT

Thread number 508503808
Thread number 500111104
Thread number 483325696
Thread number 491718400
*/