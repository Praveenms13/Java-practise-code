class Pattern9 {
    public static void main(String[] args) {
        int n = 4;
        for (int i=1;i<=n;i++) {
            for (int y=0;y<n-i;y++) {
                System.out.print(" ");
            }
            for (int j=0;j<i;j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int i=1;i<=n;i++) {
            for (int y=0;y<i;y++) {
                System.out.print(" ");
            }
            for (int j=0;j<n-i;j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}