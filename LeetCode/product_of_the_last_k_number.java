// Problem: Product of the Last K Numbers
// Link: https://leetcode.com/problems/product-of-the-last-k-numbers/

// Approach (Prefix Product with Zero Handling):
// 1. Maintain a prefix product list where prefix[i] = product of first i numbers.
// 2. On add(num):
//      - If num == 0, reset prefix list.
//      - Else prefix.add(prefix.getLast() * num).
// 3. On getProduct(k):
//      - If k >= prefix.size(), return 0 (means zero was inside last k numbers).
//      - Else return prefix[last] / prefix[last-k].
// Time Complexity: O(1) for both add() and getProduct().
// Space Complexity: O(n).


class ProductOfNumbers {
    List<Integer> listProduct;

    public ProductOfNumbers() {
        listProduct=new ArrayList();
        listProduct.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            listProduct=new ArrayList();
            listProduct.add(1);
        }else{
            listProduct.add(listProduct.get(listProduct.size()-1)*num);    
        }    
    }
    
    public int getProduct(int k) {
        if(k>listProduct.size()-1){
            return 0;
        }
        else{
            return listProduct.get(listProduct.size()-1)/listProduct.get(listProduct.size()-1-k);
        }
        
    }
}
