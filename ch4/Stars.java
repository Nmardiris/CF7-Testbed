package gr.aueb.cf.ch4;

/**
 * Prints different outputs of stars.
 */
public class Stars {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.printf("*");
        }

        for (int i = 1; i <= 10 ;i++) {
            System.out.println("*");
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 1st row: star
        // 2nd row : 2 stars
        // 3nd row : 3 stars, κλπ ( αυξάνονται )

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 10; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
