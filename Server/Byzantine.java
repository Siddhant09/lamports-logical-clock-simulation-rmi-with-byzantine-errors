package Server;
public class Byzantine {

    public boolean byzantineError() {
        int error = 0;
        try {
            error = 1 + (int) (Math.random() * ((3 - 1) + 1));
        } catch (Exception ex) {
            System.out.println("Byzantine error - " + ex.getMessage());
        }
        return error == 1 ? true : false;
    }
}
