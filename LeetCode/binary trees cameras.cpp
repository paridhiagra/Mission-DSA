class Solution {
public:
        int ans=0;
        unordered_set<TreeNode*>covered;
        void dfs(TreeNode* root,TreeNode* parent){
            if(!root) return;
            
            dfs(root->left,root);
            dfs(root->right,root);
            
            if((parent==NULL && covered.find(root)==covered.end()) ||
            (covered.find(root->left)==covered.end()) || 
            (covered.find(root->right)==covered.end())){
                ans++;
                
                // Put Camera
                covered.insert(parent);
                covered.insert(root);
                covered.insert(root->left);
                covered.insert(root->right);
            }
        }
    int minCameraCover(TreeNode* root) {
        covered.clear();
        
        // Read Above NOTE
        covered.insert(NULL);
        ans=0;
        
        dfs(root,NULL);
        return ans;
    }
};
