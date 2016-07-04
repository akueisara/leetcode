/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxDepth(struct TreeNode* root) {
      // Start typing your C/C++ solution below  
      // DO NOT write int main() function  
      if(root == NULL)  {
        return 0;  
      }
      
      int lDepth = maxDepth(root->left);  
      int rDepth = maxDepth(root->right);  
      /* use the larger one */
      if (lDepth > rDepth) 
           return(lDepth+1);
      else return(rDepth+1);  
}