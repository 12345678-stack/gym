import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2020-10-15
 * Time:
 * Project:gym
 * Copyright: MIT
 */
class ReceptionistenTest {
    Receptionisten receptionisten = new Receptionisten("src/customers.txt");

    ReceptionistenTest() throws IOException {
    }

    @Test
    void findCustomer() {
        assertTrue(receptionisten.findCustomer("7805211234"));
        assertFalse(receptionisten.findCustomer("8201294751"));

    }

    @Test
    void isCurrentMember() {
        assertTrue(receptionisten.isCurrentMember("7805211234"));
        assertFalse(receptionisten.isCurrentMember("9902149834"));
    }
}


