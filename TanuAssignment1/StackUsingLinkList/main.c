#include <stdio.h>
#include <conio.h>
#include<malloc.h>
#include<stdlib.h>

struct node{
    int a;
    struct node *p;

};
struct node *top;
void push(int);
void display();
int pop();
void main()
{int i,push_elem;
 top=NULL;
while(1)
 {
     printf("enter the following:\n1 push\n2 pop\n3 display \n4 exit\n");
     scanf("%d",&i);
     switch(i)
     {
         case 1:printf("enter the element to be pushed:");
                scanf("%d",&push_elem);
                push(push_elem);
                break;
        case 2:
               printf("popped element is:%d\n",pop());
               break;
        case 3:printf("elements of stack are\n");
               display();
               break;
        case 4:exit(0);
        default:printf("please enter correct value\n");
     }
 }
getch();
}

void push(int t)
{
    struct node *temp;
    temp=(struct node*)malloc(sizeof(struct node));
        temp->a=t;
        temp->p=NULL;
     if(top==NULL)
        top=temp;
     else
        temp->p=top;
     top=temp;
}

void display()
{
    struct node *temp;
    temp=top;
    while(temp!=NULL)
    {
        printf("%d ",temp->a);
        temp=temp->p;
    }
}

int pop()
{
    int t;
    t=top->a;
    top=top->p;
    return t;
}
