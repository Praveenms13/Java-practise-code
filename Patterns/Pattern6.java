class Pattern6 {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            int num;
            if (i % 2 != 0) {
                num = 1;
            } else {
                num = 0;
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num = 1 - num;
            }
            System.out.println();
        }
    }
}
