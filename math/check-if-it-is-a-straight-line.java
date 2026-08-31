class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // First two points
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        // Check all other points
        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];

            // Cross multiplication to avoid division
            if ((x1 - x0) * (y2 - y1) != (y1 - y0) * (x2 - x1)) {
                return false;
            }
        }
        return true;
    }
}