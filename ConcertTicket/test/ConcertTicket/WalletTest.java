package ConcertTicket;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Hunter Young
 */
public class WalletTest {

    public WalletTest() {
    }

    /**
     * Test of add method, of class Wallet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Wallet instance = new Wallet();
        ConcertTicket ct1;
        ConcertTicket ct2;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            ct1 = new ConcertTicket("Band 1", df.parse("01/15/2024"), 18.5);
            ct2 = new ConcertTicket("Band 2", df.parse("01/15/2024"), 20 );
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            fail("Exception instantiating ConcertTickets in testAdd");
            return;
        }
        assertEquals(0, instance.getSize());
        instance.add(ct1);
        assertEquals(1, instance.getSize());
        instance.add(ct2);
        assertEquals(2, instance.getSize());
        assertTrue(instance.tickets[1].compareTo(ct2) == 0);
    }

    /**
     * Test of remove method, of class Wallet.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Wallet instance = new Wallet();
        ConcertTicket ct1;
        ConcertTicket ct2;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            ct1 = new ConcertTicket("Band 1", df.parse("09/20/2020"), 18.5);
            ct2 = new ConcertTicket("Band 2", df.parse("09/30/2020"), 20 );
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            fail("Exception instantiating ConcertTickets in testRemove");
            return;
        }
        instance.add(ct1);
        instance.add(ct2);
        ConcertTicket firstRemoved = instance.remove();
        ConcertTicket secondRemoved = instance.remove();
        assertEquals(0, instance.getSize());
        assertTrue(ct2.compareTo(firstRemoved) == 0);
        assertTrue(ct1.compareTo(secondRemoved) == 0);
    }

    /**
     * Test of resize method, of class Wallet.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        Wallet instance = new Wallet();
        ConcertTicket ct11;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        for(int i = 0; i < 10; i++)
        {
            try
            {
                instance.add(new ConcertTicket("Band " + (1 + i), df.parse("1/15/2024"), 18.5 + i));
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
                fail("Exception instantiating ConcertTickets in testResize");
                return;
            }
        }
        try
        {
            ct11 = new ConcertTicket("Band 11", df.parse("1/15/2024"), 28.5);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            fail("Exception instantiating ConcertTickets in testResize");
            return;
        }
        assertEquals(10, instance.getSize());
        assertEquals(10, instance.tickets.length);
        instance.add(ct11);
        assertEquals(11, instance.getSize());
        assertEquals(20, instance.tickets.length);
    }

    /**
     * Test of toString method, of class Wallet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Wallet instance = new Wallet();
        ConcertTicket ct1;
        ConcertTicket ct2;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            ct1 = new ConcertTicket("Band 1", df.parse("01/15/2024"), 18.5);
            ct2 = new ConcertTicket("Band 2", df.parse("01/16/2024"), 20 );
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            fail("Exception instantiating ConcertTickets in testAdd");
            return;
        }
        assertEquals("[]", instance.toString());
        instance.add(ct1);
        assertEquals("[ConcertTicket{name=Band 1, date=Mon Jan 15 00:00:00 EST 2024, price=18.5}]", instance.toString());
        instance.add(ct2);
        assertEquals("[ConcertTicket{name=Band 1, date=Mon Jan 15 00:00:00 EST 2024, price=18.5}, ConcertTicket{name=Band 2, date=Tue Jan 16 00:00:00 EST 2024, price=20.0}]", instance.toString());
    }

    /**
     * Test of getSize method, of class Wallet.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Wallet instance = new Wallet();
        ConcertTicket ct1;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            ct1 = new ConcertTicket("Band 1", df.parse("01/15/2024"), 18.5);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            fail("Exception instantiating ConcertTickets in testAdd");
            return;
        }
        assertEquals(0, instance.getSize());
        instance.add(ct1);
        assertEquals(1, instance.getSize());
        instance.remove();
        assertEquals(0, instance.getSize());
    }
}
