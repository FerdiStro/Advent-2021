package Solutions.Test;

import Solutions.Scanner.Scann;

public interface testInterface2 {
    default Scann halloWord(){
        Scann scann = new Scann();
        return scann;
    }




}
