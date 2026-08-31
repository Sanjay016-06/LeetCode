class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> finalResult = new ArrayList();
        if (products == null || products.length == 0 || searchWord == null || searchWord.isEmpty()) {
            return finalResult;
        }
        Arrays.sort(products);
        List<String> possibleProductList = new ArrayList();
        for(String product: products) {
            possibleProductList.add(product);
        }
        for(int i=0; i<searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            List<String> filteredList = new ArrayList();
            for(String product: possibleProductList) {
                if(i < product.length() && c == product.charAt(i)) {
                        filteredList.add(product);
                }
            }
            List<String> intermediateResult = new ArrayList();
            for(int j=0; j < 3 && j<filteredList.size(); j++) {
                intermediateResult.add(filteredList.get(j));
            }
            finalResult.add(intermediateResult);
            possibleProductList = filteredList;
        }
        return finalResult;
    }
}