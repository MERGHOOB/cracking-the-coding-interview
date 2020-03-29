package com.margub.questions;

import com.margub.chap2.Node;

/*
Input: the node c:from linked list : a->b->c->d->e->f
output: a->b->d->e->f
 */
public class Ch2_3_DeleteMiddleElement {

    private void deleteMiddleNode(Node middle) {
        // We don't have a head pointer
        // so we can traverse to get prev node of middle.
        //Other thing we can do is to replace the value of middle node to next node and delete next node
        //as it is middle and is given that one node must be after middle

        middle.val = middle.next.val; //c->d->e, this part c replace by d: d->d->e
        middle.next = middle.next.next; // d->d  to just d->e
    }
}
