class Solution {
    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int partition(int[][] points, int l, int h) {
        int mid = l + (h - l) / 2;
        int[] pivotPoint =  points[mid];
        int pivotDistance = distance(pivotPoint);
        int i = l;

        points[mid] = points[h];
        points[h] = pivotPoint;

        for (int j = l; j < h; j++) {
            if (distance(points[j]) <= pivotDistance) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }

        points[h] = points[i];
        points[i] = pivotPoint;

        return i; 
    }

   
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, h = points.length - 1;
        int pivot = points.length;

        while (pivot != k) {
            pivot = partition(points, l, h);
            if (pivot < k) {
                l = pivot + 1;
            } else {
                h = pivot - 1;
            }
        }

        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
}

