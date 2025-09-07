// Problem: Product of the Last K Numbers
// Link: https://leetcode.com/problems/product-of-the-last-k-numbers/
//
// Approach (Prefix Product with Zero Handling):
// 1. Maintain a list 'listProduct' of prefix products:
//      - listProduct[i] = product of all numbers added so far up to index i (1-based).
//      - Initialize with 1 to simplify calculations.
//
// 2. On add(num):
//      - If num == 0:
//          • Reset listProduct to [1], because any product including 0 will be 0.
//      - Else:
//          • Append listProduct.get(last) * num to the list.
//
// 3. On getProduct(k):
//      - If k >= listProduct.size() → zero exists within the last k numbers → return 0.
//      - Else → return listProduct[last] / listProduct[last - k].
//
// 4. Why this works:
//      - Using prefix products allows computing the product of any contiguous segment in O(1).
//      - Resetting on zero ensures correct handling of zeros inside last k numbers.
//
// Time Complexity: O(1) for both add() and getProduct()
// Space Complexity: O(n) (storing prefix products)



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
