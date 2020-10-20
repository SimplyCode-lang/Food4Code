//A Binary Search is a sorting algorithm, that is used to search an element in a sorted array. 

 #include<stdio.h>  
int main()
{
int A[100], i, m, n, first, last, mid;
printf("Enter the number of elements of an array:: ");
scanf("%d",&m);

printf("Enter the elements of an array in ascending order::");
for(i=0;i<m;i++)
scanf("%d",&A[i]);

printf("Enter the element to be searched:: ");
scanf("%d",&n);

first=0;                             
last=m-1;                            
mid= (first+last)/2;                

 while(first<=last)                 
  {
   if(A[mid]<n)                     
    {
     first=mid+1;
    }
   else if(A[mid]==n)               
    {
     printf("Searched Element %d is found in the array at position %d." ,n,mid+1);
     break;
    }
   else
     last=mid-1;                    
     mid=(first+last)/2;

  }
  if(first>last)                     
  printf("Sorry!!....Element does not exist in the array.");
  return 0;
  }
