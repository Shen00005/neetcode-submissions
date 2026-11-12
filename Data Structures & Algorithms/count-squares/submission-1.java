class CountSquares {
    private HashMap<Integer, HashMap<Integer, Integer>> D;


    public CountSquares() {
        this.D = new HashMap<>();
        
    }
    // D[x] = {[y] = count}
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!this.D.containsKey(x)) {
            this.D.put(x, new HashMap<>());
        }
        HashMap<Integer, Integer> yMap = this.D.get(x);

        if (yMap.containsKey(y)) {
            int count = yMap.get(y);
            yMap.put(y, count + 1);
        } else yMap.put(y, 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        HashMap<Integer, Integer> xMap = this.D.get(x);
        if (xMap == null) return 0;
        int possibleRes = 0;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : this.D.entrySet()) {
            Integer key = entry.getKey();
            HashMap<Integer, Integer> innerMap = entry.getValue();
            
            int d = Math.abs(x-key);
            if (d == 0 || !innerMap.containsKey(y)) continue;

            int baseCount = innerMap.get(y);
            int[] possibleY = {y+d, y-d};
            for (int ny : possibleY) {
                if (!innerMap.containsKey(ny)) continue;
                if (!xMap.containsKey(ny)) continue;
                int possibleSquares = baseCount*xMap.get(ny)*innerMap.get(ny);
                possibleRes += possibleSquares;
            } 

        }

        return possibleRes;

    }
}
