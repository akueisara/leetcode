/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
void swapChildren(struct TreeNode *node)
{
    if (node) {
        struct TreeNode *temp = node->left;
        node->left = node->right;
        node->right = temp;
    }
}

struct Queue {
    struct TreeNode *node;
    struct Queue *next;
    struct Queue *prev;
};

struct Queue *pushQ(struct Queue *head, struct TreeNode *node)
{
    struct Queue *newEntry = NULL;

    if (node) {
        newEntry = (struct Queue*)malloc(sizeof(struct Queue));
        if (!newEntry)
            exit(1);
        newEntry->node = node;

        newEntry->next = head->next;
        newEntry->prev = head;

        head->next->prev = newEntry;
        head->next = newEntry;
    }

    return newEntry;
}

struct TreeNode *popQ(struct Queue *head)
{
    struct Queue *targetEntry = NULL;
    struct TreeNode *targetNode = NULL;

    if (head->prev != head) {
        targetEntry = head->prev;
        targetEntry->prev->next = head;
        head->prev = targetEntry->prev;
    }

    if (targetEntry) {
        targetNode = targetEntry->node;
        free(targetEntry);
    }

    return targetNode;
}

bool isQEmpty(struct Queue *head)
{
    return head->prev == head;
}

struct Queue head = {
    .node = NULL,
    .next = &head,
    .prev = &head,
};


struct TreeNode* invertTree(struct TreeNode* root) {
 
    struct TreeNode *curNode = NULL;
    pushQ(&head, root);
    while (!isQEmpty(&head)) {
        curNode = popQ(&head);
        swapChildren(curNode);
        pushQ(&head, curNode->left);
        pushQ(&head, curNode->right);
    }
    return root;
    
    /** recursive version
     * 
        if (root == NULL) return NULL;
        struct TreeNode *left = root->left, *right = root->right;
        root->left = right; root->right = left;
        if (left!=NULL) invertTree(left);
        if (right!=NULL) invertTree(right);  
        return root;
    */
   
}