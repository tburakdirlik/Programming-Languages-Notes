#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/time.h>

void *threadFunc (void *parg){
	
	int myNum = *((int*)parg);
	printf("Thread number %d", myNum);
	printf(" is working \n");
	

	
	return 0;
}

int main (void){
        
    int NUM_THREADS = 8;
    
	int i;
	pthread_t tid[NUM_THREADS];
	for (i=0; i<NUM_THREADS; i++){
	         	int *thread_id;
                thread_id = (int *)malloc(sizeof(int));
                *thread_id = i;
                pthread_create(&tid[i], NULL, threadFunc, (void *)thread_id);
					}

	for (i=0; i<NUM_THREADS; i++){
		pthread_join(tid[i], NULL);
					}
	return 0;

}

/*

Example output

Thread number 7
Thread number 4
Thread number 3
Thread number 1
Thread number 2
Thread number 5
Thread number 0
Thread number 6

...Program finished with exit code 0
Press ENTER to exit console.

*/
