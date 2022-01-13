package conditions;

public class SwitchCase {

    public static void main(String[] args) {
        int i = 1 ;
        int value = 1;
        switchOp(value);

    }

    public static void switchOp(int value){

        switch (value){
            case 1:
            case 2:
                System.out.println("2");
                break;
            case 3:
            case 4:
                System.out.println("3-4");
            break;
            default:
                System.out.println("default");
        }
    }
}
