package City;

public class City {

    public void startCity() {
        test();
    }

    void test() {
        InnerSquares square = new InnerSquares();
        square.squareName = "Vicroty Square";
        System.out.println(square.squareName);
        InnerStreets street = new InnerStreets();
        street.streetName = "Skriganova street";
        System.out.println(street.streetName);
        InnerAvenues avenue = new InnerAvenues();
        avenue.avenueName = "Independance avenue";
        System.out.println(avenue.avenueName);

    }

    class InnerSquares {

        String squareName;
    }

    class InnerStreets {

        String streetName;
    }

    class InnerAvenues {

        String avenueName;
    }

}
